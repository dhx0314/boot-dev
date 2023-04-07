package cn.dhx.util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dhx
 */
public class ListUtils {

    public static <T> List<List<T>> splitListByGroupSize(List<T> list, int groupSize) {
        List<List<T>> resultList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return resultList;
        }

        int total = list.size();

        if (groupSize >= total) {
            resultList.add(list);
            return resultList;
        } else if (groupSize < 1) {
            //元素个数最少1个
            groupSize = 1;
        }

        int groupCount = total / groupSize + (total % groupSize > 0 ? 1 : 0);

        //把列表按指定大小拆分为多个List
        for (int i = 0; i < groupCount; i++) {
            int start = i * groupSize, end = i == groupCount - 1 ? total : (i + 1) * groupSize;
            resultList.add(list.subList(start, end));
        }

        return resultList;
    }

}
