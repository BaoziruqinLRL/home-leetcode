package com.yyhome.leetcode.other;

import com.alibaba.fastjson.JSON;
import lombok.var;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author miluo
 * @date 2020-03-05
 */
public class BigFile {

    public static void main(String[] args){
       System.out.println(JSON.toJSONString((new BigFile()).extractLines("",5)));
    }

    private List<String> extractLines(String filePath, int n){
        var li = new ArrayList<String>();
        new FileReader("/Users/admin/Downloads/BigFile.txt",1024,3,li).startRead();
        return li;
    }

    public class FileReader {
        private int threadNum = 3;//线程数,默认为3
        private String filePath;//文件路径
        private int bufSize = 1024;//缓冲区大小,默认为1024
        private ExecutorService threadPool;
        private List<String> li;

        public FileReader(String filePath,int bufSize,int threadNum, List<String> li){
            this.threadNum = threadNum;
            this.bufSize = bufSize;
            this.filePath = filePath;
            this.threadPool = Executors.newFixedThreadPool(threadNum);
            this.li = li;
        }

        /**
         * 启动多线程读取文件
         */
        public void startRead() {
            FileChannel infile = null;
            try {
                RandomAccessFile raf = new RandomAccessFile(filePath, "r");
                infile = raf.getChannel();
                long size = infile.size();
                long subSize = size / threadNum;
                for (int i = 0; i < threadNum; i++) {
                    long startIndex = i * subSize;
                    if (size % threadNum > 0 && i == threadNum - 1) {
                        subSize += size % threadNum;
                    }
                    RandomAccessFile accessFile = new RandomAccessFile(filePath, "r");
                    FileChannel inch = accessFile.getChannel();
                    threadPool.execute(new MultiThreadReader(inch, startIndex, subSize, bufSize, li));
                }
                threadPool.shutdown();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (infile != null) {
                        infile.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class MultiThreadReader implements Runnable{
        private FileChannel channel;
        private long startIndex;
        private long rSize;
        private int bufSize;
        private List<String> li;

        public MultiThreadReader(FileChannel channel,long startIndex,long rSize,int bufSize,List<String> li){
            this.channel = channel;
            this.startIndex = startIndex > 0?startIndex - 1:startIndex;
            this.rSize = rSize;
            this.bufSize = bufSize;
            this.li = li;
        }

        @Override
        public void run(){
            readByLine();
        }

        /**
         * 按行读取文件实现逻辑
         * @return
         */
        public void readByLine(){
            try {
                ByteBuffer rbuf = ByteBuffer.allocate(bufSize);
                channel.position(startIndex);//设置读取文件的起始位置
                long endIndex = startIndex + rSize;//读取文件数据的结束位置
                byte[] temp = new byte[0];//用来缓存上次读取剩下的部分
                int LF = "\n".getBytes()[0];//换行符
                boolean isEnd = false;//用于判断数据是否读取完
                boolean isWholeLine = false;//用于判断第一行读取到的是否是完整的一行
                long lineCount = 0;//行数统计
                long endLineIndex = startIndex;//当前处理字节所在位置
                while(channel.read(rbuf) != -1 && !isEnd){
                    int position = rbuf.position();
                    byte[] rbyte = new byte[position];
                    rbuf.flip();
                    rbuf.get(rbyte);
                    int startnum = 0;//每行的起始位置下标，相对于当前所读取到的byte数组
                    //判断是否有换行符
                    //如果读取到最后一行不是完整的一行时，则继续往后读取直至读取到完整的一行才结束
                    for(int i = 0; i < rbyte.length; i++){
                        endLineIndex++;
                        if(rbyte[i] == LF){//若存在换行符
                            if(channel.position() == startIndex){//若改数据片段第一个字节为换行符，说明第一行读取到的是完整的一行
                                isWholeLine = true;
                                startnum = i + 1;
                            }else{
                                byte[] line = new byte[temp.length + i - startnum + 1];
                                System.arraycopy(temp, 0, line, 0, temp.length);
                                System.arraycopy(rbyte, startnum, line, temp.length, i - startnum + 1);
                                startnum = i + 1;
                                lineCount++;
                                temp = new byte[0];
                                //处理数据
                                if(startIndex != 0){//如果不是第一个数据段
                                    if(lineCount == 1){
                                        if(isWholeLine){//当且仅当第一行为完整行时才处理
                                            li.add(new String(line));
                                        }
                                    }else{
                                        li.add(new String(line));
                                    }
                                }else{
                                    li.add(new String(line));
                                }
                                //结束读取的判断
                                if(endLineIndex >= endIndex){
                                    isEnd = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!isEnd && startnum < rbyte.length){//说明rbyte最后还剩不完整的一行
                        byte[] temp2 = new byte[temp.length + rbyte.length - startnum];
                        System.arraycopy(temp, 0, temp2, 0, temp.length);
                        System.arraycopy(rbyte, startnum, temp2, temp.length, rbyte.length - startnum);
                        temp = temp2;
                    }
                    rbuf.clear();
                }
                //兼容最后一行没有换行的情况
                if(temp.length > 0){
                    System.out.println("兼容最后一行没有换行的情况");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
