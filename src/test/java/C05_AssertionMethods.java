import org.junit.Test;

import static org.junit.Assert.*;



public class /**/C05_AssertionMethods {

    @Test
    public void assertEqualsTest() {
        // Assert.assertEquals("Expected Result","Actual Result");   buradaki expected ile actual birbirine eşit ise test geçer, değil ise test kalır.
        // .assertEquals() metodu iki tane parametre kabul eder. Parametreleri karşılaştırma yapar.
        // 1'inci parametre expected, 2'nci parametre ise actual result içindir
        //3 parametreli kullanıldığı zaman birinci parametreye failure mesajı konulabilir

        String greet = "Hello World";
        assertEquals("Hello World", greet);
        assertEquals("String değerler birbirine uymadı","Hello WorldX", greet);

    }

    @Test
    public void assertTrueTest(){
        //Assert.assertTrue(); burada () parantez içindeki değer true ise test geçer, değilse test fail olur
        // .assertTrue() metodunun parantez içindeki değer true dönerse,test geçer, false dönerse test kalır
        // Bir testten true sonucunu bekliyorsak .assertTrue() kullanırız. Yani pozitif senoryalarda.
        // Bir testten false sonucunu bekliyorsak .assertFalse() kullanırız. Yani negatif senaryolarda.
        //2 parametreli kullanıldığı zaman birinci parametreye failure mesajı konulabilir

        boolean condition = "Hello".contains("lo");
        assertTrue(condition);

    }

    @Test
    public void assertFalseTest(){

        //.assertFalse() metodunun parantez içindeki değeri False dönerse test geçer, true dönerse test kalır.
        //2 parametreli kullanıldığı zaman birinci parametreye failure mesajı konulabilir

        boolean condition = "Hello".contains("la");
        assertFalse(condition);
        assertFalse("Condition 'true' döndü", condition);
    }

    @Test
    public void assertNullTest(){

        //Assert.assertNull() metodunun parantez içindeki değeri null ise test geçer, aksi taktirde fail olur

        String name = null;
        assertNull(name);

    }

    @Test
    public void assertNotNullTest(){

        //Assert.assertNotNull() metodunun parantez içindeki değeri null DEĞİL ise test geçer, null is fail olur

        String name = "John";
        assertNotNull(name);
    }

    @Test
    public void assertSameTest(){

        // Assert.assertSame() metodu içindeki 2 değerin referansları karşılaştırır.
        // Aynı referanslara sahiplerse, test geçer, değillerse test kalır

        String name1 = "John";
        String name2 = "John";
        String name3 = new String("John");// new keyword'ü ile String Pool dışında yeni bir obje ile yeni bir referans elde ettik.

        assertSame(name1, name2); // --> Geçer
        assertSame(name1, name3); // --> Kalır

    }

    @Test
    public void assertNotSameTest(){

        // Assert.assertNotSame() metodu içindeki 2 değerin referansları karşılaştırır.
        // Farklı referanslara sahiplerse, test geçer, aksi taktirde test kalır

        String name1 = "John";
        String name2 = "John";
        String name3 = new String("John");// new keyword'ü ile String Pool dışında yeni bir obje ile yeni bir referans elde ettik.

        assertNotSame(name1, name3); // --> Geçer
        assertNotSame(name1, name2); // --> Kalır

    }


}
