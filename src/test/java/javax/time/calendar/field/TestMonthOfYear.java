/*
 * Copyright (c) 2008-2010, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.time.calendar.field;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.io.Serializable;
import java.util.Locale;

import javax.time.calendar.IllegalCalendarFieldValueException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test MonthOfYear.
 *
 * @author Michael Nascimento Santos
 * @author Stephen Colebourne
 */
@Test
public class TestMonthOfYear {

    private static final Year YEAR_STANDARD = Year.isoYear(2007);
    private static final Year YEAR_LEAP = Year.isoYear(2008);
    private static final int MAX_LENGTH = 12;

    @BeforeMethod
    public void setUp() {
    }

    //-----------------------------------------------------------------------
    public void test_interfaces() {
        assertTrue(Enum.class.isAssignableFrom(MonthOfYear.class));
        assertTrue(Serializable.class.isAssignableFrom(MonthOfYear.class));
        assertTrue(Comparable.class.isAssignableFrom(MonthOfYear.class));
    }

    //-----------------------------------------------------------------------
    public void test_factory_int_singleton() {
        for (int i = 1; i <= MAX_LENGTH; i++) {
            MonthOfYear test = MonthOfYear.monthOfYear(i);
            assertEquals(test.getValue(), i);
            assertSame(MonthOfYear.monthOfYear(i), test);
        }
    }

    @Test(expectedExceptions=IllegalCalendarFieldValueException.class)
    public void test_factory_int_tooLow() {
        MonthOfYear.monthOfYear(0);
    }

    @Test(expectedExceptions=IllegalCalendarFieldValueException.class)
    public void test_factory_int_tooHigh() {
        MonthOfYear.monthOfYear(13);
    }

    //-----------------------------------------------------------------------
    // getShortText()
    //-----------------------------------------------------------------------
    public void test_getShortText_US() {
        assertEquals(MonthOfYear.JANUARY.getShortText(Locale.US), "Jan");
        assertEquals(MonthOfYear.FEBRUARY.getShortText(Locale.US), "Feb");
        assertEquals(MonthOfYear.MARCH.getShortText(Locale.US), "Mar");
        assertEquals(MonthOfYear.APRIL.getShortText(Locale.US), "Apr");
        assertEquals(MonthOfYear.MAY.getShortText(Locale.US), "May");
        assertEquals(MonthOfYear.JUNE.getShortText(Locale.US), "Jun");
        assertEquals(MonthOfYear.JULY.getShortText(Locale.US), "Jul");
        assertEquals(MonthOfYear.AUGUST.getShortText(Locale.US), "Aug");
        assertEquals(MonthOfYear.SEPTEMBER.getShortText(Locale.US), "Sep");
        assertEquals(MonthOfYear.OCTOBER.getShortText(Locale.US), "Oct");
        assertEquals(MonthOfYear.NOVEMBER.getShortText(Locale.US), "Nov");
        assertEquals(MonthOfYear.DECEMBER.getShortText(Locale.US), "Dec");
    }

    public void test_getShortText_pt_BR() {
        Locale ptBR = new Locale("pt", "BR");
        assertEquals(MonthOfYear.JANUARY.getShortText(ptBR), "Jan");
        assertEquals(MonthOfYear.FEBRUARY.getShortText(ptBR), "Fev");
        assertEquals(MonthOfYear.MARCH.getShortText(ptBR), "Mar");
        assertEquals(MonthOfYear.APRIL.getShortText(ptBR), "Abr");
        assertEquals(MonthOfYear.MAY.getShortText(ptBR), "Mai");
        assertEquals(MonthOfYear.JUNE.getShortText(ptBR), "Jun");
        assertEquals(MonthOfYear.JULY.getShortText(ptBR), "Jul");
        assertEquals(MonthOfYear.AUGUST.getShortText(ptBR), "Ago");
        assertEquals(MonthOfYear.SEPTEMBER.getShortText(ptBR), "Set");
        assertEquals(MonthOfYear.OCTOBER.getShortText(ptBR), "Out");
        assertEquals(MonthOfYear.NOVEMBER.getShortText(ptBR), "Nov");
        assertEquals(MonthOfYear.DECEMBER.getShortText(ptBR), "Dez");
    }

    //-----------------------------------------------------------------------
    // getText()
    //-----------------------------------------------------------------------
    public void test_getText_US() {
        assertEquals(MonthOfYear.JANUARY.getText(Locale.US), "January");
        assertEquals(MonthOfYear.FEBRUARY.getText(Locale.US), "February");
        assertEquals(MonthOfYear.MARCH.getText(Locale.US), "March");
        assertEquals(MonthOfYear.APRIL.getText(Locale.US), "April");
        assertEquals(MonthOfYear.MAY.getText(Locale.US), "May");
        assertEquals(MonthOfYear.JUNE.getText(Locale.US), "June");
        assertEquals(MonthOfYear.JULY.getText(Locale.US), "July");
        assertEquals(MonthOfYear.AUGUST.getText(Locale.US), "August");
        assertEquals(MonthOfYear.SEPTEMBER.getText(Locale.US), "September");
        assertEquals(MonthOfYear.OCTOBER.getText(Locale.US), "October");
        assertEquals(MonthOfYear.NOVEMBER.getText(Locale.US), "November");
        assertEquals(MonthOfYear.DECEMBER.getText(Locale.US), "December");
    }

    public void test_getText_pt_BR() {
        Locale ptBR = new Locale("pt", "BR");
        assertEquals(MonthOfYear.JANUARY.getText(ptBR), "Janeiro");
        assertEquals(MonthOfYear.FEBRUARY.getText(ptBR), "Fevereiro");
        assertEquals(MonthOfYear.MARCH.getText(ptBR), "Mar\u00E7o");
        assertEquals(MonthOfYear.APRIL.getText(ptBR), "Abril");
        assertEquals(MonthOfYear.MAY.getText(ptBR), "Maio");
        assertEquals(MonthOfYear.JUNE.getText(ptBR), "Junho");
        assertEquals(MonthOfYear.JULY.getText(ptBR), "Julho");
        assertEquals(MonthOfYear.AUGUST.getText(ptBR), "Agosto");
        assertEquals(MonthOfYear.SEPTEMBER.getText(ptBR), "Setembro");
        assertEquals(MonthOfYear.OCTOBER.getText(ptBR), "Outubro");
        assertEquals(MonthOfYear.NOVEMBER.getText(ptBR), "Novembro");
        assertEquals(MonthOfYear.DECEMBER.getText(ptBR), "Dezembro");
    }

    //-----------------------------------------------------------------------
    // next()
    //-----------------------------------------------------------------------
    public void test_next() {
        assertEquals(MonthOfYear.JANUARY.next(), MonthOfYear.FEBRUARY);
        assertEquals(MonthOfYear.FEBRUARY.next(), MonthOfYear.MARCH);
        assertEquals(MonthOfYear.MARCH.next(), MonthOfYear.APRIL);
        assertEquals(MonthOfYear.APRIL.next(), MonthOfYear.MAY);
        assertEquals(MonthOfYear.MAY.next(), MonthOfYear.JUNE);
        assertEquals(MonthOfYear.JUNE.next(), MonthOfYear.JULY);
        assertEquals(MonthOfYear.JULY.next(), MonthOfYear.AUGUST);
        assertEquals(MonthOfYear.AUGUST.next(), MonthOfYear.SEPTEMBER);
        assertEquals(MonthOfYear.SEPTEMBER.next(), MonthOfYear.OCTOBER);
        assertEquals(MonthOfYear.OCTOBER.next(), MonthOfYear.NOVEMBER);
        assertEquals(MonthOfYear.NOVEMBER.next(), MonthOfYear.DECEMBER);
        assertEquals(MonthOfYear.DECEMBER.next(), MonthOfYear.JANUARY);
    }

    //-----------------------------------------------------------------------
    // previous()
    //-----------------------------------------------------------------------
    public void test_previous() {
        assertEquals(MonthOfYear.JANUARY.previous(), MonthOfYear.DECEMBER);
        assertEquals(MonthOfYear.FEBRUARY.previous(), MonthOfYear.JANUARY);
        assertEquals(MonthOfYear.MARCH.previous(), MonthOfYear.FEBRUARY);
        assertEquals(MonthOfYear.APRIL.previous(), MonthOfYear.MARCH);
        assertEquals(MonthOfYear.MAY.previous(), MonthOfYear.APRIL);
        assertEquals(MonthOfYear.JUNE.previous(), MonthOfYear.MAY);
        assertEquals(MonthOfYear.JULY.previous(), MonthOfYear.JUNE);
        assertEquals(MonthOfYear.AUGUST.previous(), MonthOfYear.JULY);
        assertEquals(MonthOfYear.SEPTEMBER.previous(), MonthOfYear.AUGUST);
        assertEquals(MonthOfYear.OCTOBER.previous(), MonthOfYear.SEPTEMBER);
        assertEquals(MonthOfYear.NOVEMBER.previous(), MonthOfYear.OCTOBER);
        assertEquals(MonthOfYear.DECEMBER.previous(), MonthOfYear.NOVEMBER);
    }

    //-----------------------------------------------------------------------
    // roll(int)
    //-----------------------------------------------------------------------
    public void test_roll_january() {
        assertEquals(MonthOfYear.JANUARY.roll(-12), MonthOfYear.JANUARY);
        assertEquals(MonthOfYear.JANUARY.roll(-11), MonthOfYear.FEBRUARY);
        assertEquals(MonthOfYear.JANUARY.roll(-10), MonthOfYear.MARCH);
        assertEquals(MonthOfYear.JANUARY.roll(-9), MonthOfYear.APRIL);
        assertEquals(MonthOfYear.JANUARY.roll(-8), MonthOfYear.MAY);
        assertEquals(MonthOfYear.JANUARY.roll(-7), MonthOfYear.JUNE);
        assertEquals(MonthOfYear.JANUARY.roll(-6), MonthOfYear.JULY);
        assertEquals(MonthOfYear.JANUARY.roll(-5), MonthOfYear.AUGUST);
        assertEquals(MonthOfYear.JANUARY.roll(-4), MonthOfYear.SEPTEMBER);
        assertEquals(MonthOfYear.JANUARY.roll(-3), MonthOfYear.OCTOBER);
        assertEquals(MonthOfYear.JANUARY.roll(-2), MonthOfYear.NOVEMBER);
        assertEquals(MonthOfYear.JANUARY.roll(-1), MonthOfYear.DECEMBER);
        assertEquals(MonthOfYear.JANUARY.roll(0), MonthOfYear.JANUARY);
        assertEquals(MonthOfYear.JANUARY.roll(1), MonthOfYear.FEBRUARY);
        assertEquals(MonthOfYear.JANUARY.roll(2), MonthOfYear.MARCH);
        assertEquals(MonthOfYear.JANUARY.roll(3), MonthOfYear.APRIL);
        assertEquals(MonthOfYear.JANUARY.roll(4), MonthOfYear.MAY);
        assertEquals(MonthOfYear.JANUARY.roll(5), MonthOfYear.JUNE);
        assertEquals(MonthOfYear.JANUARY.roll(6), MonthOfYear.JULY);
        assertEquals(MonthOfYear.JANUARY.roll(7), MonthOfYear.AUGUST);
        assertEquals(MonthOfYear.JANUARY.roll(8), MonthOfYear.SEPTEMBER);
        assertEquals(MonthOfYear.JANUARY.roll(9), MonthOfYear.OCTOBER);
        assertEquals(MonthOfYear.JANUARY.roll(10), MonthOfYear.NOVEMBER);
        assertEquals(MonthOfYear.JANUARY.roll(11), MonthOfYear.DECEMBER);
        assertEquals(MonthOfYear.JANUARY.roll(12), MonthOfYear.JANUARY);
    }

    public void test_roll_july() {
        assertEquals(MonthOfYear.JULY.roll(-12), MonthOfYear.JULY);
        assertEquals(MonthOfYear.JULY.roll(-11), MonthOfYear.AUGUST);
        assertEquals(MonthOfYear.JULY.roll(-10), MonthOfYear.SEPTEMBER);
        assertEquals(MonthOfYear.JULY.roll(-9), MonthOfYear.OCTOBER);
        assertEquals(MonthOfYear.JULY.roll(-8), MonthOfYear.NOVEMBER);
        assertEquals(MonthOfYear.JULY.roll(-7), MonthOfYear.DECEMBER);
        assertEquals(MonthOfYear.JULY.roll(-6), MonthOfYear.JANUARY);
        assertEquals(MonthOfYear.JULY.roll(-5), MonthOfYear.FEBRUARY);
        assertEquals(MonthOfYear.JULY.roll(-4), MonthOfYear.MARCH);
        assertEquals(MonthOfYear.JULY.roll(-3), MonthOfYear.APRIL);
        assertEquals(MonthOfYear.JULY.roll(-2), MonthOfYear.MAY);
        assertEquals(MonthOfYear.JULY.roll(-1), MonthOfYear.JUNE);
        assertEquals(MonthOfYear.JULY.roll(0), MonthOfYear.JULY);
        assertEquals(MonthOfYear.JULY.roll(1), MonthOfYear.AUGUST);
        assertEquals(MonthOfYear.JULY.roll(2), MonthOfYear.SEPTEMBER);
        assertEquals(MonthOfYear.JULY.roll(3), MonthOfYear.OCTOBER);
        assertEquals(MonthOfYear.JULY.roll(4), MonthOfYear.NOVEMBER);
        assertEquals(MonthOfYear.JULY.roll(5), MonthOfYear.DECEMBER);
        assertEquals(MonthOfYear.JULY.roll(6), MonthOfYear.JANUARY);
        assertEquals(MonthOfYear.JULY.roll(7), MonthOfYear.FEBRUARY);
        assertEquals(MonthOfYear.JULY.roll(8), MonthOfYear.MARCH);
        assertEquals(MonthOfYear.JULY.roll(9), MonthOfYear.APRIL);
        assertEquals(MonthOfYear.JULY.roll(10), MonthOfYear.MAY);
        assertEquals(MonthOfYear.JULY.roll(11), MonthOfYear.JUNE);
        assertEquals(MonthOfYear.JULY.roll(12), MonthOfYear.JULY);
    }

    //-----------------------------------------------------------------------
    // lengthInDays(Year)
    //-----------------------------------------------------------------------
    public void test_lengthInDays_notLeapYear() {
        Year year = YEAR_STANDARD;
        assertEquals(MonthOfYear.JANUARY.lengthInDays(year), 31);
        assertEquals(MonthOfYear.FEBRUARY.lengthInDays(year), 28);
        assertEquals(MonthOfYear.MARCH.lengthInDays(year), 31);
        assertEquals(MonthOfYear.APRIL.lengthInDays(year), 30);
        assertEquals(MonthOfYear.MAY.lengthInDays(year), 31);
        assertEquals(MonthOfYear.JUNE.lengthInDays(year), 30);
        assertEquals(MonthOfYear.JULY.lengthInDays(year), 31);
        assertEquals(MonthOfYear.AUGUST.lengthInDays(year), 31);
        assertEquals(MonthOfYear.SEPTEMBER.lengthInDays(year), 30);
        assertEquals(MonthOfYear.OCTOBER.lengthInDays(year), 31);
        assertEquals(MonthOfYear.NOVEMBER.lengthInDays(year), 30);
        assertEquals(MonthOfYear.DECEMBER.lengthInDays(year), 31);
    }

    public void test_lengthInDays_leapYear() {
        Year year = YEAR_LEAP;
        assertEquals(MonthOfYear.JANUARY.lengthInDays(year), 31);
        assertEquals(MonthOfYear.FEBRUARY.lengthInDays(year), 29);
        assertEquals(MonthOfYear.MARCH.lengthInDays(year), 31);
        assertEquals(MonthOfYear.APRIL.lengthInDays(year), 30);
        assertEquals(MonthOfYear.MAY.lengthInDays(year), 31);
        assertEquals(MonthOfYear.JUNE.lengthInDays(year), 30);
        assertEquals(MonthOfYear.JULY.lengthInDays(year), 31);
        assertEquals(MonthOfYear.AUGUST.lengthInDays(year), 31);
        assertEquals(MonthOfYear.SEPTEMBER.lengthInDays(year), 30);
        assertEquals(MonthOfYear.OCTOBER.lengthInDays(year), 31);
        assertEquals(MonthOfYear.NOVEMBER.lengthInDays(year), 30);
        assertEquals(MonthOfYear.DECEMBER.lengthInDays(year), 31);
    }

    @Test(expectedExceptions=NullPointerException.class)
    public void test_lengthInDays_nullYear() {
        MonthOfYear.JANUARY.lengthInDays((Year) null);
    }

    //-----------------------------------------------------------------------
    // lengthInDays(boolean)
    //-----------------------------------------------------------------------
    public void test_lengthInDays_boolean_notLeapYear() {
        assertEquals(MonthOfYear.JANUARY.lengthInDays(false), 31);
        assertEquals(MonthOfYear.FEBRUARY.lengthInDays(false), 28);
        assertEquals(MonthOfYear.MARCH.lengthInDays(false), 31);
        assertEquals(MonthOfYear.APRIL.lengthInDays(false), 30);
        assertEquals(MonthOfYear.MAY.lengthInDays(false), 31);
        assertEquals(MonthOfYear.JUNE.lengthInDays(false), 30);
        assertEquals(MonthOfYear.JULY.lengthInDays(false), 31);
        assertEquals(MonthOfYear.AUGUST.lengthInDays(false), 31);
        assertEquals(MonthOfYear.SEPTEMBER.lengthInDays(false), 30);
        assertEquals(MonthOfYear.OCTOBER.lengthInDays(false), 31);
        assertEquals(MonthOfYear.NOVEMBER.lengthInDays(false), 30);
        assertEquals(MonthOfYear.DECEMBER.lengthInDays(false), 31);
    }

    public void test_lengthInDays_boolean_leapYear() {
        assertEquals(MonthOfYear.JANUARY.lengthInDays(true), 31);
        assertEquals(MonthOfYear.FEBRUARY.lengthInDays(true), 29);
        assertEquals(MonthOfYear.MARCH.lengthInDays(true), 31);
        assertEquals(MonthOfYear.APRIL.lengthInDays(true), 30);
        assertEquals(MonthOfYear.MAY.lengthInDays(true), 31);
        assertEquals(MonthOfYear.JUNE.lengthInDays(true), 30);
        assertEquals(MonthOfYear.JULY.lengthInDays(true), 31);
        assertEquals(MonthOfYear.AUGUST.lengthInDays(true), 31);
        assertEquals(MonthOfYear.SEPTEMBER.lengthInDays(true), 30);
        assertEquals(MonthOfYear.OCTOBER.lengthInDays(true), 31);
        assertEquals(MonthOfYear.NOVEMBER.lengthInDays(true), 30);
        assertEquals(MonthOfYear.DECEMBER.lengthInDays(true), 31);
    }

    //-----------------------------------------------------------------------
    // minLengthInDays()
    //-----------------------------------------------------------------------
    public void test_minLengthInDays() {
        assertEquals(MonthOfYear.JANUARY.minLengthInDays(), 31);
        assertEquals(MonthOfYear.FEBRUARY.minLengthInDays(), 28);
        assertEquals(MonthOfYear.MARCH.minLengthInDays(), 31);
        assertEquals(MonthOfYear.APRIL.minLengthInDays(), 30);
        assertEquals(MonthOfYear.MAY.minLengthInDays(), 31);
        assertEquals(MonthOfYear.JUNE.minLengthInDays(), 30);
        assertEquals(MonthOfYear.JULY.minLengthInDays(), 31);
        assertEquals(MonthOfYear.AUGUST.minLengthInDays(), 31);
        assertEquals(MonthOfYear.SEPTEMBER.minLengthInDays(), 30);
        assertEquals(MonthOfYear.OCTOBER.minLengthInDays(), 31);
        assertEquals(MonthOfYear.NOVEMBER.minLengthInDays(), 30);
        assertEquals(MonthOfYear.DECEMBER.minLengthInDays(), 31);
    }

    //-----------------------------------------------------------------------
    // maxLengthInDays()
    //-----------------------------------------------------------------------
    public void test_maxLengthInDays() {
        assertEquals(MonthOfYear.JANUARY.maxLengthInDays(), 31);
        assertEquals(MonthOfYear.FEBRUARY.maxLengthInDays(), 29);
        assertEquals(MonthOfYear.MARCH.maxLengthInDays(), 31);
        assertEquals(MonthOfYear.APRIL.maxLengthInDays(), 30);
        assertEquals(MonthOfYear.MAY.maxLengthInDays(), 31);
        assertEquals(MonthOfYear.JUNE.maxLengthInDays(), 30);
        assertEquals(MonthOfYear.JULY.maxLengthInDays(), 31);
        assertEquals(MonthOfYear.AUGUST.maxLengthInDays(), 31);
        assertEquals(MonthOfYear.SEPTEMBER.maxLengthInDays(), 30);
        assertEquals(MonthOfYear.OCTOBER.maxLengthInDays(), 31);
        assertEquals(MonthOfYear.NOVEMBER.maxLengthInDays(), 30);
        assertEquals(MonthOfYear.DECEMBER.maxLengthInDays(), 31);
    }

    //-----------------------------------------------------------------------
    // getLastDayOfMonth(boolean)
    //-----------------------------------------------------------------------
    public void test_getLastDayOfMonth_notLeapYear() {
        assertEquals(MonthOfYear.JANUARY.getLastDayOfMonth(false), 31);
        assertEquals(MonthOfYear.FEBRUARY.getLastDayOfMonth(false), 28);
        assertEquals(MonthOfYear.MARCH.getLastDayOfMonth(false), 31);
        assertEquals(MonthOfYear.APRIL.getLastDayOfMonth(false), 30);
        assertEquals(MonthOfYear.MAY.getLastDayOfMonth(false), 31);
        assertEquals(MonthOfYear.JUNE.getLastDayOfMonth(false), 30);
        assertEquals(MonthOfYear.JULY.getLastDayOfMonth(false), 31);
        assertEquals(MonthOfYear.AUGUST.getLastDayOfMonth(false), 31);
        assertEquals(MonthOfYear.SEPTEMBER.getLastDayOfMonth(false), 30);
        assertEquals(MonthOfYear.OCTOBER.getLastDayOfMonth(false), 31);
        assertEquals(MonthOfYear.NOVEMBER.getLastDayOfMonth(false), 30);
        assertEquals(MonthOfYear.DECEMBER.getLastDayOfMonth(false), 31);
    }

    public void test_getLastDayOfMonth_leapYear() {
        assertEquals(MonthOfYear.JANUARY.getLastDayOfMonth(true), 31);
        assertEquals(MonthOfYear.FEBRUARY.getLastDayOfMonth(true), 29);
        assertEquals(MonthOfYear.MARCH.getLastDayOfMonth(true), 31);
        assertEquals(MonthOfYear.APRIL.getLastDayOfMonth(true), 30);
        assertEquals(MonthOfYear.MAY.getLastDayOfMonth(true), 31);
        assertEquals(MonthOfYear.JUNE.getLastDayOfMonth(true), 30);
        assertEquals(MonthOfYear.JULY.getLastDayOfMonth(true), 31);
        assertEquals(MonthOfYear.AUGUST.getLastDayOfMonth(true), 31);
        assertEquals(MonthOfYear.SEPTEMBER.getLastDayOfMonth(true), 30);
        assertEquals(MonthOfYear.OCTOBER.getLastDayOfMonth(true), 31);
        assertEquals(MonthOfYear.NOVEMBER.getLastDayOfMonth(true), 30);
        assertEquals(MonthOfYear.DECEMBER.getLastDayOfMonth(true), 31);
    }

//    //-----------------------------------------------------------------------
//    // getQuarterOfYear()
//    //-----------------------------------------------------------------------
//    public void test_getQuarterOfYear() {
//        assertEquals(MonthOfYear.JANUARY.getQuarterOfYear(), QuarterOfYear.Q1);
//        assertEquals(MonthOfYear.FEBRUARY.getQuarterOfYear(), QuarterOfYear.Q1);
//        assertEquals(MonthOfYear.MARCH.getQuarterOfYear(), QuarterOfYear.Q1);
//        assertEquals(MonthOfYear.APRIL.getQuarterOfYear(), QuarterOfYear.Q2);
//        assertEquals(MonthOfYear.MAY.getQuarterOfYear(), QuarterOfYear.Q2);
//        assertEquals(MonthOfYear.JUNE.getQuarterOfYear(), QuarterOfYear.Q2);
//        assertEquals(MonthOfYear.JULY.getQuarterOfYear(), QuarterOfYear.Q3);
//        assertEquals(MonthOfYear.AUGUST.getQuarterOfYear(), QuarterOfYear.Q3);
//        assertEquals(MonthOfYear.SEPTEMBER.getQuarterOfYear(), QuarterOfYear.Q3);
//        assertEquals(MonthOfYear.OCTOBER.getQuarterOfYear(), QuarterOfYear.Q4);
//        assertEquals(MonthOfYear.NOVEMBER.getQuarterOfYear(), QuarterOfYear.Q4);
//        assertEquals(MonthOfYear.DECEMBER.getQuarterOfYear(), QuarterOfYear.Q4);
//    }
//
//    //-----------------------------------------------------------------------
//    // getMonthOfQuarter()
//    //-----------------------------------------------------------------------
//    public void test_getMonthOfQuarter() {
//        assertEquals(MonthOfYear.JANUARY.getMonthOfQuarter(), 1);
//        assertEquals(MonthOfYear.FEBRUARY.getMonthOfQuarter(), 2);
//        assertEquals(MonthOfYear.MARCH.getMonthOfQuarter(), 3);
//        assertEquals(MonthOfYear.APRIL.getMonthOfQuarter(), 1);
//        assertEquals(MonthOfYear.MAY.getMonthOfQuarter(), 2);
//        assertEquals(MonthOfYear.JUNE.getMonthOfQuarter(), 3);
//        assertEquals(MonthOfYear.JULY.getMonthOfQuarter(), 1);
//        assertEquals(MonthOfYear.AUGUST.getMonthOfQuarter(), 2);
//        assertEquals(MonthOfYear.SEPTEMBER.getMonthOfQuarter(), 3);
//        assertEquals(MonthOfYear.OCTOBER.getMonthOfQuarter(), 1);
//        assertEquals(MonthOfYear.NOVEMBER.getMonthOfQuarter(), 2);
//        assertEquals(MonthOfYear.DECEMBER.getMonthOfQuarter(), 3);
//    }

    //-----------------------------------------------------------------------
    // toString()
    //-----------------------------------------------------------------------
    public void test_toString() {
        assertEquals(MonthOfYear.JANUARY.toString(), "JANUARY");
        assertEquals(MonthOfYear.FEBRUARY.toString(), "FEBRUARY");
        assertEquals(MonthOfYear.MARCH.toString(), "MARCH");
        assertEquals(MonthOfYear.APRIL.toString(), "APRIL");
        assertEquals(MonthOfYear.MAY.toString(), "MAY");
        assertEquals(MonthOfYear.JUNE.toString(), "JUNE");
        assertEquals(MonthOfYear.JULY.toString(), "JULY");
        assertEquals(MonthOfYear.AUGUST.toString(), "AUGUST");
        assertEquals(MonthOfYear.SEPTEMBER.toString(), "SEPTEMBER");
        assertEquals(MonthOfYear.OCTOBER.toString(), "OCTOBER");
        assertEquals(MonthOfYear.NOVEMBER.toString(), "NOVEMBER");
        assertEquals(MonthOfYear.DECEMBER.toString(), "DECEMBER");
    }

    //-----------------------------------------------------------------------
    // generated methods
    //-----------------------------------------------------------------------
    public void test_enum() {
        assertEquals(MonthOfYear.valueOf("JANUARY"), MonthOfYear.JANUARY);
        assertEquals(MonthOfYear.values()[0], MonthOfYear.JANUARY);
    }

}
