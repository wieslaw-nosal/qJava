/**
 *  Copyright (c) 2011-2014 Exxeleron GmbH
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.exxeleron.qjava;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestDateTime {

    @Test
    public void testQDate() {
        final Calendar c = Calendar.getInstance();
        c.set(1995, 6, 1);
        assertEquals(-1645, (Object) new QDate(c.getTime()).getValue());
        c.set(1999, 0, 1);
        assertEquals(-365, (Object) new QDate(c.getTime()).getValue());
        c.set(2000, 0, 1);
        assertEquals(0, (Object) new QDate(c.getTime()).getValue());
        c.set(2005, 6, 1);
        assertEquals(2008, (Object) new QDate(c.getTime()).getValue());
        c.set(2010, 0, 1);
        assertEquals(3653, (Object) new QDate(c.getTime()).getValue());

        assertEquals(Integer.MIN_VALUE, (Object) new QDate((Date) null).getValue());
    }

    @Test
    public void testQDateToString() {
        assertEquals("1995.07.01", new QDate(-1645).toString());
        assertEquals("1999.01.01", new QDate(-365).toString());
        assertEquals("2000.01.01", new QDate(0).toString());
        assertEquals("2005.07.01", new QDate(2008).toString());
        assertEquals("2010.01.01", new QDate(3653).toString());

        assertEquals("0Nd", new QDate(Integer.MIN_VALUE).toString());
    }

    @Test
    public void testQDateFromString() {
        assertEquals(new QDate(-1645), QDate.fromString("1995.07.01"));
        assertEquals(new QDate(-365), QDate.fromString("1999.01.01"));
        assertEquals(new QDate(0), QDate.fromString("2000.01.01"));
        assertEquals(new QDate(2008), QDate.fromString("2005.07.01"));
        assertEquals(new QDate(3653), QDate.fromString("2010.01.01"));

        assertEquals(new QDate(Integer.MIN_VALUE), QDate.fromString(null));
        assertEquals(new QDate(Integer.MIN_VALUE), QDate.fromString(""));
        assertEquals(new QDate(Integer.MIN_VALUE), QDate.fromString("0Nd"));
    }

    @Test
    public void testQDateTime() {
        final Calendar c = Calendar.getInstance();
        c.set(1999, 0, 1, 23, 59, 59);
        c.set(Calendar.MILLISECOND, 0);
        assertEquals(-364.0000116, new QDateTime(c.getTime()).getValue(), 0.1);
        c.set(2000, 0, 1, 0, 0, 0);
        assertEquals(0., new QDateTime(c.getTime()).getValue(), 0.1);
        c.set(2005, 6, 1, 1, 59, 59);
        assertEquals(2008.0833218, new QDateTime(c.getTime()).getValue(), 0.1);
        c.set(2010, 0, 1, 14, 23, 42);
        assertEquals(3653.599792, new QDateTime(c.getTime()).getValue(), 0.1);

        assertEquals(Double.NaN, (Object) new QDateTime((Date) null).getValue());
    }

    @Test
    public void testQDateTimeToString() {
        assertEquals(true, new QDateTime(-364.0000115).toString().startsWith("1999.01.01T23:59:59.0"));
        assertEquals("2000.01.01T00:00:00.000", new QDateTime(0.).toString());
        assertEquals(true, new QDateTime(2008.0833218).toString().startsWith("2005.07.01T01:59:59.0"));
        assertEquals(true, new QDateTime(3653.599792).toString().startsWith("2010.01.01T14:23:42.0"));

        assertEquals("0Nz", new QDateTime(Double.NaN).toString());
    }

    @Test
    public void testQDateTimeFromString() {
        assertEquals(new QDateTime(-364.0000115).getValue(), QDateTime.fromString("1999.01.01T23:59:59.000").getValue(), 0.001);
        assertEquals(new QDateTime(0.).getValue(), QDateTime.fromString("2000.01.01T00:00:00.000").getValue(), 0.001);
        assertEquals(new QDateTime(2008.0833218).getValue(), QDateTime.fromString("2005.07.01T01:59:59.000").getValue(), 0.001);
        assertEquals(new QDateTime(3653.599792).getValue(), QDateTime.fromString("2010.01.01T14:23:42.000").getValue(), 0.001);

        assertEquals(new QDateTime(Double.NaN), QDateTime.fromString(null));
        assertEquals(new QDateTime(Double.NaN), QDateTime.fromString(""));
        assertEquals(new QDateTime(Double.NaN), QDateTime.fromString("0Nz"));
    }

    @Test
    public void testQMinute() {
        final Calendar c = Calendar.getInstance();
        c.set(2000, 0, 1, 0, 0);
        assertEquals(0, (Object) new QMinute(c.getTime()).getValue());
        c.set(2000, 0, 1, 13, 30);
        assertEquals(810, (Object) new QMinute(c.getTime()).getValue());
        c.set(2000, 0, 1, 23, 59);
        assertEquals(1439, (Object) new QMinute(c.getTime()).getValue());

        assertEquals(Integer.MIN_VALUE, (Object) new QMinute((Date) null).getValue());
    }

    @Test
    public void testQMinuteToString() {
        assertEquals("00:00", new QMinute(0).toString());
        assertEquals("13:30", new QMinute(810).toString());
        assertEquals("23:59", new QMinute(1439).toString());

        assertEquals("0Nu", new QMinute(Integer.MIN_VALUE).toString());
    }

    @Test
    public void testQMinuteFromString() {
        assertEquals(new QMinute(0), QMinute.fromString("00:00"));
        assertEquals(new QMinute(810), QMinute.fromString("13:30"));
        assertEquals(new QMinute(1439), QMinute.fromString("23:59"));

        assertEquals(new QMinute(Integer.MIN_VALUE), QMinute.fromString(null));
        assertEquals(new QMinute(Integer.MIN_VALUE), QMinute.fromString(""));
        assertEquals(new QMinute(Integer.MIN_VALUE), QMinute.fromString("0Nu"));
    }

    @Test
    public void testQMonth() {
        final Calendar c = Calendar.getInstance();
        c.set(1995, 0, 1);
        assertEquals(-60, (Object) new QMonth(c.getTime()).getValue());
        c.set(1995, 6, 1);
        assertEquals(-54, (Object) new QMonth(c.getTime()).getValue());
        c.set(2000, 0, 1);
        assertEquals(0, (Object) new QMonth(c.getTime()).getValue());
        c.set(2005, 6, 1);
        assertEquals(66, (Object) new QMonth(c.getTime()).getValue());
        c.set(2010, 0, 1);
        assertEquals(120, (Object) new QMonth(c.getTime()).getValue());

        assertEquals(Integer.MIN_VALUE, (Object) new QMonth((Date) null).getValue());
    }

    @Test
    public void testQMonthToString() {
        assertEquals("1995.01m", new QMonth(-60).toString());
        assertEquals("1995.07m", new QMonth(-54).toString());
        assertEquals("2000.01m", new QMonth(0).toString());
        assertEquals("2005.07m", new QMonth(66).toString());
        assertEquals("2010.01m", new QMonth(120).toString());

        assertEquals("0Nm", new QMonth(Integer.MIN_VALUE).toString());
    }

    @Test
    public void testQMonthFromString() {
        assertEquals(new QMonth(-60), QMonth.fromString("1995.01m"));
        assertEquals(new QMonth(-54), QMonth.fromString("1995.07m"));
        assertEquals(new QMonth(0), QMonth.fromString("2000.01m"));
        assertEquals(new QMonth(66), QMonth.fromString("2005.07m"));
        assertEquals(new QMonth(120), QMonth.fromString("2010.01m"));

        assertEquals(new QMonth(Integer.MIN_VALUE), QMonth.fromString(null));
        assertEquals(new QMonth(Integer.MIN_VALUE), QMonth.fromString(""));
        assertEquals(new QMonth(Integer.MIN_VALUE), QMonth.fromString("0Nm"));
    }

    @Test
    public void testQSecond() {
        final Calendar c = Calendar.getInstance();
        c.set(2000, 0, 1, 0, 0, 0);
        assertEquals(0, (Object) new QSecond(c.getTime()).getValue());
        c.set(2000, 0, 1, 13, 30, 13);
        assertEquals(48613, (Object) new QSecond(c.getTime()).getValue());
        c.set(2000, 0, 1, 23, 59, 59);
        assertEquals(86399, (Object) new QSecond(c.getTime()).getValue());

        assertEquals(Integer.MIN_VALUE, (Object) new QSecond((Date) null).getValue());
    }

    @Test
    public void testQSecondToString() {
        assertEquals("00:00:00", new QSecond(0).toString());
        assertEquals("13:30:13", new QSecond(48613).toString());
        assertEquals("23:59:59", new QSecond(86399).toString());

        assertEquals("0Nv", new QSecond(Integer.MIN_VALUE).toString());
    }

    @Test
    public void testQSecondFromString() {
        assertEquals(new QSecond(0), QSecond.fromString("00:00:00"));
        assertEquals(new QSecond(48613), QSecond.fromString("13:30:13"));
        assertEquals(new QSecond(86399), QSecond.fromString("23:59:59"));

        assertEquals(new QSecond(Integer.MIN_VALUE), QSecond.fromString(null));
        assertEquals(new QSecond(Integer.MIN_VALUE), QSecond.fromString(""));
        assertEquals(new QSecond(Integer.MIN_VALUE), QSecond.fromString("0Nv"));
    }

    @Test
    public void testQTime() {
        final Calendar c = Calendar.getInstance();
        c.set(2000, 0, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        assertEquals(0, (Object) new QTime(c.getTime()).getValue());
        c.set(2000, 0, 1, 13, 30, 13);
        assertEquals(48613000, (Object) new QTime(c.getTime()).getValue());
        c.set(2000, 0, 1, 23, 59, 59);
        assertEquals(86399000, (Object) new QTime(c.getTime()).getValue());

        assertEquals(Integer.MIN_VALUE, (Object) new QTime((Date) null).getValue());
    }

    @Test
    public void testQTimeToString() {
        assertEquals("00:00:00.000", new QTime(0).toString());
        assertEquals("13:30:13.000", new QTime(48613000).toString());
        assertEquals("23:59:59.000", new QTime(86399000).toString());

        assertEquals("0Nt", new QTime(Integer.MIN_VALUE).toString());
    }

    @Test
    public void testQTimeFromString() {
        assertEquals(new QTime(48613000), QTime.fromString("13:30:13.000"));
        assertEquals(new QTime(0), QTime.fromString("00:00:00.000"));
        assertEquals(new QTime(86399000), QTime.fromString("23:59:59.000"));

        assertEquals(new QTime(Integer.MIN_VALUE), QTime.fromString(null));
        assertEquals(new QTime(Integer.MIN_VALUE), QTime.fromString(""));
        assertEquals(new QTime(Integer.MIN_VALUE), QTime.fromString("0Nt"));
    }

    @Test
    public void testQTimespan() {
        final Calendar c = Calendar.getInstance();
        c.set(2000, 0, 1, 0, 0, 0);
        c.set(Calendar.MILLISECOND, 0);
        assertEquals(0L, (Object) new QTimespan(c.getTime()).getValue());
        c.set(2000, 0, 1, 13, 30, 13);
        assertEquals(48613000000000L, (Object) new QTimespan(c.getTime()).getValue());
        c.set(2000, 0, 1, 23, 59, 59);
        assertEquals(86399000000000L, (Object) new QTimespan(c.getTime()).getValue());

        assertEquals(Long.MIN_VALUE, (Object) new QTimespan((Date) null).getValue());
    }

    @Test
    public void testQTimespanToString() {
        assertEquals("0D00:00:00.000000000", new QTimespan(0L).toString());
        assertEquals("0D13:30:13.000000000", new QTimespan(48613000000000L).toString());
        assertEquals("0D13:30:13.000000100", new QTimespan(48613000000100L).toString());
        assertEquals("-0D13:30:13.000001000", new QTimespan(-48613000001000L).toString());
        assertEquals("1D13:30:13.000000000", new QTimespan(135013000000000L).toString());
        assertEquals("0D23:59:59.000000000", new QTimespan(86399000000000L).toString());
        assertEquals("2D23:59:59.000000000", new QTimespan(259199000000000L).toString());
        assertEquals("-2D23:59:59.000000000", new QTimespan(-259199000000000L).toString());

        assertEquals("0Nn", new QTimespan(Long.MIN_VALUE).toString());
    }

    @Test
    public void testQTimespanFromString() {
        assertEquals(new QTimespan(0L), QTimespan.fromString("0D00:00:00.000000000"));
        assertEquals(new QTimespan(48613000000000L), QTimespan.fromString("0D13:30:13.000000000"));
        assertEquals(new QTimespan(48613000000100L), QTimespan.fromString("0D13:30:13.000000100"));
        assertEquals(new QTimespan(-48613000000000L), QTimespan.fromString("-0D13:30:13.000000000"));
        assertEquals(new QTimespan(-48613000010000L), QTimespan.fromString("-0D13:30:13.000010000"));
        assertEquals(new QTimespan(135013000000000L), QTimespan.fromString("1D13:30:13.000000000"));
        assertEquals(new QTimespan(86399000000000L), QTimespan.fromString("0D23:59:59.000000000"));
        assertEquals(new QTimespan(259199000000000L), QTimespan.fromString("2D23:59:59.000000000"));
        assertEquals(new QTimespan(-259199000000000L), QTimespan.fromString("-2D23:59:59.000000000"));

        assertEquals(new QTimespan(Long.MIN_VALUE), QTimespan.fromString(null));
        assertEquals(new QTimespan(Long.MIN_VALUE), QTimespan.fromString(""));
        assertEquals(new QTimespan(Long.MIN_VALUE), QTimespan.fromString("0Nn"));
    }

    @Test
    public void testQTimestamp() {
        final Calendar c = Calendar.getInstance();
        c.set(1995, 6, 1, 13, 30, 13);
        c.set(Calendar.MILLISECOND, 0);
        assertEquals(-142079387000000000L, (Object) new QTimestamp(c.getTime()).getValue());
        c.set(1999, 0, 1, 23, 59, 59);
        assertEquals(-31449601000000000L, (Object) new QTimestamp(c.getTime()).getValue());
        c.set(2000, 0, 1, 0, 0, 0);
        assertEquals(0L, (Object) new QTimestamp(c.getTime()).getValue());
        c.set(2005, 6, 1, 1, 59, 59);
        assertEquals(173498399000000000L, (Object) new QTimestamp(c.getTime()).getValue());
        c.set(2010, 0, 1, 14, 23, 42);
        assertEquals(315671022000000000L, (Object) new QTimestamp(c.getTime()).getValue());

        assertEquals(Long.MIN_VALUE, (Object) new QTimestamp((Date) null).getValue());
    }

    @Test
    public void testQTimestampToString() {
        assertEquals("1995.07.01D13:30:13.000000000", new QTimestamp(-142079387000000000L).toString());
        assertEquals("1999.01.01D23:59:59.000000000", new QTimestamp(-31449601000000000L).toString());
        assertEquals("2000.01.01D00:00:00.000000000", new QTimestamp(0L).toString());
        assertEquals("2005.07.01D01:59:59.000000012", new QTimestamp(173498399000000012L).toString());
        assertEquals("2010.01.01D14:23:42.000000066", new QTimestamp(315671022000000066L).toString());

        assertEquals("0Np", new QTimestamp(Long.MIN_VALUE).toString());
    }

    @Test
    public void testQTimestampFromString() {
        assertEquals(new QTimestamp(-142079387000000000L), QTimestamp.fromString("1995.07.01D13:30:13.000000000"));
        assertEquals(new QTimestamp(-31449601000000000L), QTimestamp.fromString("1999.01.01D23:59:59.000000000"));
        assertEquals(new QTimestamp(0L), QTimestamp.fromString("2000.01.01D00:00:00.000000000"));
        assertEquals(new QTimestamp(173498399000000012L), QTimestamp.fromString("2005.07.01D01:59:59.000000012"));
        assertEquals(new QTimestamp(315671022000000066L), QTimestamp.fromString("2010.01.01D14:23:42.000000066"));

        assertEquals(new QTimestamp(Long.MIN_VALUE), QTimestamp.fromString(null));
        assertEquals(new QTimestamp(Long.MIN_VALUE), QTimestamp.fromString(""));
        assertEquals(new QTimestamp(Long.MIN_VALUE), QTimestamp.fromString("0Np"));
    }
}
