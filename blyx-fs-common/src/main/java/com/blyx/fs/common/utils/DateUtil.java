package com.blyx.fs.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author quyang5
 * @description 日期工具类
 * @date 16:57 2020/9/24
 */
@Slf4j
public class DateUtil {
    public static final DateTimeFormatter CTT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter CTT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter CTT_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter CTT_FIRST_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-01 00:00:00");
    public static final ZoneId CTT_ZONE_ID = ZoneId.of(ZoneId.SHORT_IDS.get("CTT"));

    /**
     * DateFormat yyyy-MM-dd HH:mm:ss
     * example:2020-05-06 18:24:20
     */
    public final static String LONG_DATETTIME = "yyyy-MM-dd HH:mm:ss";

    public final static String LONG_DATETIME_MINUTE="yyyy-MM-dd HH:mm";

    public final static String DAY_DATETTIME = "yyyy-MM-dd";

    public static Long createItemIdLong() {
        return System.nanoTime();
    }

    /**
     * 获取当前Instant时间
     * @return
     */
    public static Instant getCurrent(){
        return LocalDateTime.now()
                .atZone(CTT_ZONE_ID)
                .toInstant();
    }

    /**
     * 获取当前String时间
     * @return
     */
    public static String getCurrentStringDate(){
        return toStringDate(getCurrent() , CTT_DATE_TIME_FORMATTER);
    }

    public static String getCurrentTDateTime(){
        Instant current = getCurrent();
        return toStringDate(current, CTT_DATE_FORMATTER) + "T" + toStringDate(current, CTT_TIME_FORMATTER);
    }

    /**
     * 获取指定分钟后String时间
     * @return
     */
    public static String getPlusMinStringDate(Long mins){
        return toStringDate(
                LocalDateTime.now()
                        .plusMinutes(mins)
                        .atZone(CTT_ZONE_ID)
                        .toInstant()
                ,CTT_DATE_TIME_FORMATTER);
    }

    /**
     * 获取当前时间戳 milli
     * @return
     */
    public static Long getCurrentEpochMilli(){
        return getCurrent().toEpochMilli();
    }
    /**
     * 获取当前时间戳 second
     * @return
     */
    public static Long getCurrentEpochSecond(){
        return getCurrent().getEpochSecond();
    }

    /**
     * 指定时间转为时间戳 millis
     * @param timeStr
     * @return
     */
    public static Long toEpochMilli(String timeStr){
        return toInstant(timeStr).toEpochMilli();
    }
    public static Long toEpochMilli(Instant time){
        return time.toEpochMilli();
    }

    /**
     * 将时间格式化为时间戳 秒级
     * @param time
     * @return
     */
    public static Long toEpochSec(Instant time) {
        return time.getEpochSecond();
    }

    /**
     * 格式化输出时间字符串，上海时区,默认DateTimeFormatter
     */
    public static String toStringDate(Instant instant) {
        return toStringDate(instant , CTT_DATE_FORMATTER);
    }
    /**
     * 格式化输出时间，上海时区,默认DateTimeFormatter
     */
    public static Instant toInstant(String timeStr) {
        if(StringUtils.isEmpty(timeStr)) {
            return null;
        }
        return toInstant(timeStr , CTT_DATE_TIME_FORMATTER);
    }

    /**
     * 格式化输出时间字符串，上海时区,指定DateTimeFormatter
     */
    public static String toStringDate(Instant instant , DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime
                .ofInstant(instant, CTT_ZONE_ID)
                .format(dateTimeFormatter);
    }

    /**
     * 格式化输出时间字符串，上海时区,指定DateTimeFormatter
     */
    public static String toStringDateTime(Instant instant) {
        return toStringDate(instant , CTT_DATE_TIME_FORMATTER);
    }
    /**
     * 格式化输出时间，上海时区,指定DateTimeFormatter
     */
    public static Instant toInstant(String timeStr , DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime
                .parse(timeStr, dateTimeFormatter)
                .atZone(CTT_ZONE_ID)
                .toInstant();
    }

    /**
     * 格式化输出时间，上海时区
     */
    public static String toStringDate(String timeStr) {
        return DateUtil.toStringDate(DateUtil.toInstant(timeStr));
    }

    /**
     * 获取当月开始日期
     * @return
     */
    public static String getCurrentMonthFirstDate() {
        return LocalDateTime.now().atZone(CTT_ZONE_ID).format(CTT_FIRST_DATE_FORMATTER);
    }

    /**
     * 获取指定月份之后的时间
     * @param monthAdd
     * @return
     */
    public static Instant getInstantByMonth(long monthAdd) {
        return LocalDateTime.now().atZone(CTT_ZONE_ID).plusMonths(monthAdd).toInstant();
    }

    /**
     * 获取指定月份后该月份的结束日期
     * @param month
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getEndDateByMonth(int month) {
        // 获取指定月份+1后该月份的开始日期
        String afterMonthDate = LocalDateTime.now().atZone(CTT_ZONE_ID).minusMonths(-month - 1).format(CTT_FIRST_DATE_FORMATTER);
        // 日期减去一天即可
        return toStringDateTime(toInstant(afterMonthDate).minusSeconds(24 * 3600));
    }

    public static List<String> getDateByWeekDays(String startDateStr, String endDateStr, List<WeekDay> weekDays) {
        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr) || CollectionUtils.isEmpty(weekDays))
            return null;
        LocalDate startDate = LocalDate.parse(startDateStr, CTT_DATE_TIME_FORMATTER);
        LocalDate endDate = LocalDate.parse(endDateStr, CTT_DATE_TIME_FORMATTER);
        // 先计算出首批日期
        Set<LocalDate> firstDates = new HashSet<>();
        Set<String> weeks = weekDays.stream().map(Enum::name).collect(Collectors.toSet());
        for (int i = 0; i < 7; ++i) {
            LocalDate temp;
            if ((temp = startDate.plusDays(i)).compareTo(endDate) > 0) {
                temp = null; // help gc
                break; // 开始时间大于结束时间 终止
            }
            if (!weeks.contains(temp.getDayOfWeek().toString())) {
                temp = null; // help gc
                continue;
            }
            firstDates.add(temp);
        }
        List<String> res = new ArrayList<>(firstDates.stream().map(d -> d.format(CTT_DATE_FORMATTER)).collect(Collectors.toList()));
        // 直接每个日期追加7日即可
        for (LocalDate date : firstDates) {
            int i = 1;
            for (;;) {
                LocalDate temp;
                if ((temp = date.plusWeeks(i++)).compareTo(endDate) > 0) {
                    temp = null;
                    break;
                }
                res.add(temp.format(CTT_DATE_FORMATTER));
            }
        }
        return res;
    }

      /**
        * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
        *
        * @param strDate
        * @return
        */
    public static Date strToDateLong(String strDate) {
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       ParsePosition pos = new ParsePosition(0);
       Date strtodate = formatter.parse(strDate, pos);
       return strtodate;
      }


      public static Date getCurDateYMD(){
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          String dateNowStr = sdf.format(d);
          Date dateYMD=null;
          try {
              dateYMD=sdf.parse(dateNowStr);
          } catch (ParseException e) {
              e.printStackTrace();
          }
          return dateYMD;
      }

    /**
     * 获取时间的Date，
     * yyyy-MM-dd
     * @param date
     * @return Date
     *
     */
    public static Date getDateYMD(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        Date dateYMD=null;
        try {
            dateYMD=sdf.parse(dateNowStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateYMD;
    }


    public static String getDateYMDStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }
    public static String getShotStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }
    /**
     * 获取当前时间的，时间部分
     * HH:mm:ss:SSSSSSS
     * @return
     */
    public static String getTime(){
        return new SimpleDateFormat("HH:mm:ss.SSSSSSS").format(new Date());
    }


    public static Date getLongTime(String str){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try {
            Date date=dateFormat.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *获取时间部分
     * @param date
     * @return
     */
    public static String getTime(Date date){
        return new SimpleDateFormat("HH:mm:ss:SSSSSSS").format(date);
    }

    /**
     * 获取时间戳 当前时间（UTC） - 1970
     * @return long 时间戳
     */
    public static long getTimeInMillis(){
        return Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
    }


public enum WeekDay {
        MONDAY("星期一", 1),
        TUESDAY("星期二", 2),
        WEDNESDAY("星期三", 3),
        THURSDAY("星期四", 4),
        FRIDAY("星期五", 5),
        SATURDAY("星期六", 6),
        SUNDAY("星期日", 7),
        ;
        private String desc;
        private int order;

        WeekDay(String desc, int order) {
            this.desc = desc;
            this.order = order;
        }

        public int getOrder() {
            return order;
        }

        public String getDesc() {
            return desc;
        }

        public static WeekDay getByDesc(String desc) {
            Optional<WeekDay> weekDay = Arrays.stream(values()).filter(d -> d.getDesc().equals(desc)).findFirst();
            return weekDay.orElse(null);
        }
    }


    /**
     * 格式化日期
     *
     * @param currDate 日期对象
     * @return 默认格式日期字符串
     */
    public static String format(Date currDate) {
        return format(currDate, LONG_DATETTIME);
    }

    /**
     * 格式化日期
     *
     * @param currDate 日期对象
     * @param format   日期格式
     * @return 格式化的日期字符串
     */
    public static String format(Date currDate, String format) {
        if (currDate == null || StringUtils.isBlank(format)) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(currDate);
    }

    public static String dateAddT(String dateStr){
        if(dateStr.contains("T")){
            return dateStr;
        }

        if(dateStr.contains("+08:00")){
            dateStr=dateStr.replace("+08:00","");
        }

        Date date=strToDateLong(dateStr);

        if(date==null){
            return dateStr;
        }

        String ymdStr=getDateYMDStr(date);
        String shortStr=getShotStr(date);

        String result=ymdStr+"T"+shortStr;

        if(dateStr.contains("+08:00")){
            result+="+08:00";
        }

        return result;
    }


    public static int getYear(Date date){
        //传入日期
        Calendar calder = Calendar.getInstance();
        calder.setTime(date);//设置时间
        return calder.get(Calendar.YEAR);//获取年份
    }

    public static String getMinuteString(Date date){

        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATETIME_MINUTE);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 常用格式日期字符串，转换为日期
     * 转换顺序   yyyy-MM-ddTHH:mm:ss
     *           yyyy-MM-dd HH:mm:ss
     *           MM/dd/yyyy HH:mm:ss
     *           yyyy/MM/dd HH:mm:ss
     * @param dateTimeString
     * @return LocalDateTime 时间
     * @author baiaxiaoyu
     * @date 2020-12-28
     */
    public static LocalDateTime parse(String dateTimeString){

        LocalDateTime dateTime = null;

        try {
            dateTime = LocalDateTime.parse(dateTimeString);
        }catch (Exception e){
            //Log
            log.info("日期：" + dateTimeString );
        }

        if (!Objects.isNull(dateTime)){
            return dateTime;
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateTime = LocalDateTime.parse(dateTimeString, dtf);
        }catch (Exception e){
            //Log
            log.info("日期：" + dateTimeString + ",格式字符串：yyyy-MM-dd HH:mm:ss");
        }

        if (!Objects.isNull(dateTime)){
            return dateTime;
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
            dateTime = LocalDateTime.parse(dateTimeString, dtf);
        }catch (Exception e){
            //Log
            log.info("日期：" + dateTimeString + ",格式字符串：MM/dd/yyyy HH:mm:ss");
        }

        if (!Objects.isNull(dateTime)){
            return dateTime;
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            dateTime = LocalDateTime.parse(dateTimeString, dtf);
        }catch (Exception e){
            //Log
            log.info("日期：" + dateTimeString + ",格式字符串：yyyy/MM/dd HH:mm:ss");
        }

        if (!Objects.isNull(dateTime)){
            return dateTime;
        }

        return null;
    }
}
