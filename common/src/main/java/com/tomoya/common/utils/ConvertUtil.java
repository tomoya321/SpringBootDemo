///**
// * Copyright (C), 2015-2019, XXX有限公司
// * FileName: ConvertUtil
// * Author:   Administrator
// * Date:     2019/8/21 16:54
// * Description: convertutil
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.tomoya.common.utils;
//
//import com.tomoya.common.exception.MMLException;
//import org.apache.commons.beanutils.ConvertUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.util.CollectionUtils;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈convertutil〉
// *
// * @author Administrator
// * @create 2019/8/21
// * @since 1.0.0
// */
//public class ConvertUtil {
//    /**
//     * 分页实体转为DTO
//     *
//     * @param page
//     * @param kClass
//     * @param <S>
//     * @param <T>
//     * @return
//     */
//    public static <S, T> Page<T> pageEntity2DTO(Page<S> page, Class<T> kClass) {
//        List<S> content = page.getContent();
//        List<T> targetList = listEntity2DTO(content, kClass);
//        PageImpl<T> resultPage = new PageImpl<>(targetList, new PageRequest(page.getNumber(), page.getSize()), page.getTotalElements());
//        return resultPage;
//    }
//
//    /**
//     * 个性字段分页实体转为DTO
//     *
//     * @param page
//     * @param kClass
//     * @param <S>
//     * @param <T>
//     * @return
//     */
//    public static <S, T> Page<T> pageEntity2DTO(Page<S> page, Class<T> kClass, ConvertExtend<S, T> convertExtend) {
//        List<S> content = page.getContent();
//        List<T> targetList = listEntity2DTO(content, kClass, convertExtend);
//        PageImpl<T> resultPage = new PageImpl<>(targetList, new PageRequest(page.getNumber(), page.getSize()), page.getTotalElements());
//        return resultPage;
//    }
//
//    /**
//     * list实体转换dto
//     *
//     * @param list
//     * @param kClass
//     * @param <S>
//     * @param <T>
//     * @return
//     */
//    public static <S, T> List<T> listEntity2DTO(List<S> list, Class<T> kClass) {
//
//        List<T> targetList = new ArrayList<>();
//        if (CollectionUtils.isEmpty(list)) {
//            return targetList;
//        }
//        for (S s : list) {
//            T t = beanCopy(s, kClass);
//            targetList.add(t);
//        }
//        return targetList;
//    }
//
//    /**
//     * 个性字段list实体转换dto
//     *
//     * @param list
//     * @param kClass
//     * @param <S>
//     * @param <T>
//     * @return
//     */
//    public static <S, T> List<T> listEntity2DTO(List<S> list, Class<T> kClass, ConvertExtend<S, T> convertExtend) {
//        List<T> targetList = new ArrayList<>();
//        if (CollectionUtils.isEmpty(list)) {
//            return targetList;
//        }
//        for (S s : list) {
//            T t = beanCopy(s, kClass, convertExtend);
//            targetList.add(t);
//        }
//        return targetList;
//    }
//
//    /**
//     * 实体转换dto
//     *
//     * @param source
//     * @param kClass
//     * @param <S>
//     * @param <T>
//     * @return
//     */
//    public static <S, T> T beanCopy(S source, Class<T> kClass) {
//        T target;
//        try {
//            target = kClass.newInstance();
//            if (Objects.isNull(source)) {
//                return target;
//            }
//            BeanUtils.copyProperties(source, target);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MMLException("实体转换异常");
//        }
//        return target;
//    }
//
//    /**
//     * 个性字段实体转换dto
//     *
//     * @param source
//     * @param kClass
//     * @param <S>
//     * @param <T>
//     * @return
//     */
//    public static <S, T> T beanCopy(S source, Class<T> kClass, ConvertExtend<S, T> convertExtend) {
//        T t = beanCopy(source, kClass);
//        convertExtend.extend(source, t);
//        return t;
//    }
//
//    /**
//     * 字符串截取为指定格式list
//     *
//     * @param sourceArr
//     * @param targetClass
//     * @param <T>
//     * @return
//     */
//    public static <T> List<T> convertArr(String sourceArr, String regex, Class<T> targetClass) {
//        if (StringUtils.isEmpty(sourceArr)) {
//            return new ArrayList<>();
//        }
//        String[] split = sourceArr.split(regex);
//        T[] convert = (T[]) ConvertUtils.convert(split, targetClass);
//        List<T> target = Arrays.asList(convert);
//        return target;
//    }
//}