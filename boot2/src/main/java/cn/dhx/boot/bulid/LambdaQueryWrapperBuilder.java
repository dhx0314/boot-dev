package cn.dhx.boot.bulid;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.Collection;


public class LambdaQueryWrapperBuilder<T> {
    private final LambdaQueryWrapper<T> wrapper = Wrappers.lambdaQuery();

    public static <T> LambdaQueryWrapperBuilder<T> newBuilder() {
        return new LambdaQueryWrapperBuilder<T>();
    }

    public LambdaQueryWrapperBuilder<T> isNull(SFunction<T, ?> column) {
        wrapper.isNull(column);
        return this;
    }
    public LambdaQueryWrapperBuilder<T> isNull(boolean condition,SFunction<T, ?> column) {
        wrapper.isNull(condition,column);
        return this;
    }

    public LambdaQueryWrapperBuilder<T> notNull(SFunction<T, ?> column) {
        wrapper.isNotNull(column);
        return this;
    }
    public LambdaQueryWrapperBuilder<T> notNull(boolean condition,SFunction<T, ?> column) {
        wrapper.isNotNull(condition,column);
        return this;
    }

    public LambdaQueryWrapperBuilder<T> ne(SFunction<T, ?> column, Object val) {
        if (val != null) {
            wrapper.ne(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> notIn(SFunction<T, ?> column, Object... value) {
        if (value != null && value.length > 0) {
            wrapper.notIn(column, value);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> eq(SFunction<T, ?> column, Object val) {
        if (val != null) {
            wrapper.eq(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> eq(SFunction<T, ?> column, Integer val) {
        if (val != null && val >= 0) {
            wrapper.eq(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> eq(SFunction<T, ?> column, String str) {
        if (str != null && str.trim().length() > 0) {
            wrapper.eq(column, str);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> eq(boolean isEqualTo, SFunction<T, ?> column, Object val) {
        if (isEqualTo) {
            wrapper.eq(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> le(SFunction<T, ?> column, Object val) {
        if (val != null) {
            wrapper.le(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> lt(SFunction<T, ?> column, Object val) {
        if (val != null && !StrUtil.isBlankIfStr(val)) {
            wrapper.lt(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> ge(SFunction<T, ?> column, Object val) {
        if (val != null && !StrUtil.isBlankIfStr(val)) {
            wrapper.ge(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> gt(SFunction<T, ?> column, Object val) {
        if (val != null) {
            wrapper.gt(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> in(SFunction<T, ?> column, Object... values) {
        if (values != null && values.length > 0) {
            wrapper.in(column, values);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> in(SFunction<T, ?> column, Collection<?> coll) {
        if (coll != null && !coll.isEmpty()) {
            wrapper.in(column, coll);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> eqTrim(SFunction<T, ?> column, String val) {
        if (StrUtil.isNotBlank(val)) {
            wrapper.eq(column, StrUtil.trimToEmpty(val));
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> like(SFunction<T, ?> column, Object val) {
        if (val != null) {
            wrapper.like(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> like(SFunction<T, ?> column, String str) {
        if (str != null && str.trim().length() > 0) {
            wrapper.like(column, str);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> likeTrim(SFunction<T, ?> column, String val) {
        if (StrUtil.isNotBlank(val)) {
            wrapper.like(column, StrUtil.trimToEmpty(val));
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> likeRight(SFunction<T, ?> column, Object val) {
        if (val != null) {
            wrapper.likeRight(column, val);
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> likeRightTrim(SFunction<T, ?> column, String val) {
        if (StrUtil.isNotBlank(val)) {
            wrapper.likeRight(column, StrUtil.trimToEmpty(val));
        }
        return this;
    }

    public LambdaQueryWrapperBuilder<T> orderByAsc(SFunction<T, ?> column) {
        wrapper.orderByAsc(column);
        return this;
    }

    public LambdaQueryWrapperBuilder<T> orderByDesc(SFunction<T, ?> column) {
        wrapper.orderByDesc(column);
        return this;
    }

    public LambdaQueryWrapperBuilder<T> orderByDesc(SFunction<T, ?> column, String... strs) {
        if (strs == null || strs.length == 0) {
            wrapper.orderByDesc(column);
            return this;
        }
        for (String str : strs) {
            if (StrUtil.isNotBlank(str)) {
                return this;
            }
        }
        wrapper.orderByDesc(column);
        return this;
    }

    /**
     * 选项匹配，当 val 和 allQueryValue 相等时，该参数查询全部
     *
     * @param column        列名
     * @param val           属性值
     * @param allQueryValue 全部查询匹配值
     * @return 选项匹配结果
     */
    public LambdaQueryWrapperBuilder<T> optionEq(SFunction<T, ?> column, Object val, Object allQueryValue) {
        if (val != null && !allQueryValue.equals(val)) {
            wrapper.eq(column, val);
        }
        return this;
    }

    public LambdaQueryWrapper<T> lambda() {
        return wrapper;
    }
}
