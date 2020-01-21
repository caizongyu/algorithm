package com.dynamic;

import java.util.Arrays;
/**
 * È¥³ý×ÓÂ·¾¶
 * @author caizongyu
 *
 */
public class MergePath {
	private static String[] path = {
			"C:\\Program Files\\",
			"C:\\Program Filesa\\",
			"C:\\Program Files\\abc\\dep",
			"C:\\P\\a\\",
			"C:\\Program Files\\djalfal"
			};
	public static void main(String[] args) {
		String[] result=new String[path.length];
		Arrays.sort(path);
		System.out.println(Arrays.toString(path));
		String baseString = "";
		if(path!=null && path.length>1) {
			baseString=path[0];
			
		}
		int resultIndex=0;
		for(int i=1;i<path.length;i++) {
			if(path[i].contains(baseString)) {
				continue;
			}
			result[resultIndex++]=baseString;
			baseString = path[i];
		}
		System.out.println(Arrays.toString(result));
		//System.out.println("\\".compareTo("a"));
	}
}
