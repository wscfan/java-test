package cn.wscfan.common;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * @Author 王松
 * @Date 2020/2/16 20:00
 */
public class CIOTest02 {
    public static void main(String[] args) {
        Collection<File> files = FileUtils.listFiles(new File("src/cn/wscfan/io/data"), FileFilterUtils.and(EmptyFileFilter.NOT_EMPTY, new SuffixFileFilter("txt")), DirectoryFileFilter.INSTANCE);
        for(File file: files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
