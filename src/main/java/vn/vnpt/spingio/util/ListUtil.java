package vn.vnpt.spingio.util;

import java.util.List;

public class ListUtil {

	public static boolean isEmpty(List list) {
	    return (list == null || list.size() == 0);
	}
	
	public static boolean isNotEmpty(List list) {
	    return !isEmpty(list);
	}
}
