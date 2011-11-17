package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import root.admin.LwDelAction;

public class FileManager {
	/**
	 * Log
	 */
	private static final Log log = LogFactory.getLog(LwDelAction.class);

	public static final String YXLW = "/upload/YXLW";

	/**
	 * 删除文件
	 * 
	 * @param fname
	 *            指定文件名
	 * @param folderName
	 *            相对/路径
	 * @return 是否刪除成功
	 */
	public boolean deleteFile(String fname, String folderName) {
		String path = ServletActionContext.getServletContext().getRealPath(
				folderName);
		File realPath = new File(path);
		if (!realPath.isDirectory()) {
			log.error(realPath.getAbsolutePath() + "不是一个目录");
			return false;
		}
		File file = new File(realPath.getAbsolutePath() + "\\" + fname);
		if (!file.exists()) {
			log.error(file.toString() + "不存在");
			return false;
		}

		// 删除文件
		log.debug("删除文件:" + file.toString());
		if (!file.delete()) {
			log.error("删除失败");
			return false;
		}
		log.debug("删除成功");
		return true;
	}

	public boolean saveFile(String fname, File uploadfile, String folderName) {
		String path = ServletActionContext.getServletContext().getRealPath(
				folderName);
		File realPath = new File(path);
		if (!realPath.isDirectory()) {
			log.error(realPath.getAbsolutePath() + "不是一个目录");
			return false;
		}
		File file = new File(realPath.getAbsolutePath() + "\\" + fname);
		if (!file.exists()) {
			log.error(file.toString() + "不存在");
			return false;
		}

		// 创建文件
		log.debug("创建文件:" + file.toString());
		try {
			byte[] buffer = new byte[10485760];
			InputStream in = new FileInputStream(uploadfile);
			OutputStream out = new FileOutputStream(file);
			int length = in.read(buffer);
			out.write(buffer, 0, length);
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.toString());
			return false;
		}
		if (!file.exists()) {
			log.error(file.toString() + "创建失败");
			return false;
		}
		log.debug(file.toString() + "创建成功");
		return true;
	}
}
