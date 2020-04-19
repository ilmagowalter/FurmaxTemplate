package it.furmax.template.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtil {

	// Date constants
	public static final String DEFAULT_TIME_ZONE = "Europe/Rome";
	public static final String DATE_START_DEFAULT = "1900-01-01";
	public static final String YEAR_START_DEFAULT = "1900";
	public static final String PERIOD_START_DEFAULT = "01";
	public static final String DATE_END_DEFAULT = "3000-12-31";
	public static final String DATETIME_END_DEFAULT = "3000-12-31 23:59:59";
	public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_FORMAT_NO_HOURS_UNDERSCORE = "dd_MM_yyyy";
	public static final String DATE_FORMAT_UNDERSCORE = "dd_MM_yyyy_HH_mm_ss";
	public static final String DATE_FORMAT_NO_HOURS_SLASH = "dd/MM/yyyy";
	public static final String DATE_FORMAT_ISO8601 = "yyyy-MM-dd";
	public static final String DATE_FORMAT_ITALY = "dd-MM-yyyy";
	public static final String DATE_FORMAT_ONLY_HH_MM_SS = "HH:mm:ss";
	public static final String DATE_FORMAT_MILLS = "dd/MM/yyyy_HH:mm:ss.SSS";

	private DateUtil() {
	}

	/**
	 * @return parsed date or null if errors or input null
	 */
	public static Date parseDateNoErrors(final String date) {
		if (date == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setTimeZone(TimeZone.getTimeZone("CEST"));
		Date toDate;
		try {
			toDate = df.parse(date);
		} catch (ParseException e) {
			toDate = null;
		}
		return toDate;
	}

	/**
	 * @return parsed isodate or null if errors or input null
	 */
	public static Date parseIsoDateNoErrors(final String date) {
		if (date == null) {
			return null;
		}
		TimeZone tz = TimeZone.getTimeZone("CET");
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setTimeZone(tz);
		Date toDate;
		try {
			toDate = df.parse(date);
		} catch (ParseException e) {
			toDate = null;
		}
		return toDate;
	}

	/**
	 * @return formatted date, empty if null
	 */
	public static String format(final Timestamp date) {
		if (date == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(date);
	}

	/**
	 * @return formatted date, empty if null
	 */
	public static String formatMills(final Timestamp date) {
		if (date == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat(DATE_FORMAT_MILLS);
		return df.format(date);
	}

	/**
	 * @return formatted date, empty if null
	 */
	public static String format(final Date date) {
		if (date == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(date);
	}

	/**
	 * @return formatted date, empty if null
	 */
	public static String formatNoHour(final Timestamp date) {
		if (date == null) {
			return "";
		}
		DateFormat dfnh = new SimpleDateFormat(DATE_FORMAT_NO_HOURS_UNDERSCORE);
		return dfnh.format(date);
	}

	public static String formatWithUnderscore(final Timestamp date) {
		if (date == null) {
			return "";
		}
		DateFormat dfu = new SimpleDateFormat(DATE_FORMAT_UNDERSCORE);
		return dfu.format(date);
	}

	public static String formatWithUnderscore(final Timestamp date, final boolean applyTimeZone) {
		if (date == null) {
			return "";
		}
		DateFormat dfu = new SimpleDateFormat(DATE_FORMAT_UNDERSCORE);
		return dfu.format(date);
	}

	public static String formatNoHourSlash(final Timestamp date) {
		if (date == null) {
			return "";
		}
		DateFormat dfnh = new SimpleDateFormat(DATE_FORMAT_NO_HOURS_SLASH);
		return dfnh.format(date);
	}

	/**
	 * @return formatted date based on timezone
	 */
	public static String formatNoHourSlash(final ZonedDateTime date, final String timeZone) {
		if (date == null) {
			return "";
		}
		ZonedDateTime zdt = date.withZoneSameInstant(ZoneId.of(timeZone));
		DateTimeFormatter dfnh = DateTimeFormatter.ofPattern(DATE_FORMAT_NO_HOURS_SLASH);
		return dfnh.format(zdt);
	}

	public static Date convertFromUtc(Long millis) {
		Instant istant = Instant.ofEpochMilli(millis);
		return Date.from(istant);
	}

	public static String formatOnlyHour(final Timestamp date) {
		if (date == null) {
			return "";
		}
		DateFormat dfnh = new SimpleDateFormat(DATE_FORMAT_ONLY_HH_MM_SS);
		return dfnh.format(date);
	}

	/**
	 * @return formatted time based on timezone
	 */
	public static String formatOnlyHour(final ZonedDateTime date, final String timeZone) {
		if (date == null) {
			return "";
		}
		ZonedDateTime zdt = date.withZoneSameInstant(ZoneId.of(timeZone));
		DateTimeFormatter dfnh = DateTimeFormatter.ofPattern(DATE_FORMAT_ONLY_HH_MM_SS);
		return dfnh.format(zdt);
	}

	/**
	 * 
	 * @param date
	 * @param timeZone
	 * @param pattern
	 * @return formatted date and time based on timezone
	 */
	public static String formatWithTimeZone(final ZonedDateTime date, final String timeZone, final String pattern) {
		if (date == null) {
			return "";
		}
		ZonedDateTime zdt = date.withZoneSameInstant(ZoneId.of(timeZone));
		DateTimeFormatter dfnh = DateTimeFormatter.ofPattern(pattern);
		return dfnh.format(zdt);
	}

	/**
	 * @return formatted date based
	 */
	public static String formatNoHourSlash(final LocalDateTime date) {
		if (date == null) {
			return "";
		}
		DateTimeFormatter dfnh = DateTimeFormatter.ofPattern(DATE_FORMAT_NO_HOURS_SLASH);
		return date.format(dfnh);
	}
}
