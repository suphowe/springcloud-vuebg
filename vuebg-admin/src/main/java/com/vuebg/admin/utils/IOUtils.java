package com.vuebg.admin.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO相关工具类
 * @author suphowe
 * @date 2018-12-12
 */
public class IOUtils {

	/**
	 * 关闭对象，连接
	 * @param closeable
	 */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
