import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C44_FileExist {
/*

    Bilgisayarımızdaki bir dosyanın varlığını test etmek için önce o dosyaya erişmemiz gerekmektedir.
    Java'da dosyaya erişmek için dosya yoluna -pathine ihtiyacımız vardır.
    Her bilgisayarın kullanıcı adı farklı olduğundan masaüstü dosya yolu da birbirinden farklı olacaktır.
    Testlerimizin tüm bilgisayarda çalışması için dosya yolunu DİNAMİK hale getirmek zorundayız.

     Files.exists(Paths.get (filePath)); Bilgisayarınızda dosyanın olup olmadığını kontrol eder.
*/

    @Test
    public void test01() {

        //Masaüstünde kayıtlı Flower.bmp dosyasının var olup olmadığını test eden kod:
        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);//C:\Users\Clarusway

        boolean isFileExist = Files.exists(Path.of(userHome + "/Desktop/Flower.bmp"));
        assertTrue("File does not exist", isFileExist);

        //Masaüstünde bir dosyanın var OLMADIĞINI test eden kod:
        boolean isBirdExist = Files.exists(Path.of(userHome + "/Desktop/Bird.bmp"));
        assertFalse("Bird exists", isBirdExist);

    }

    @Test
    public void test02(){
        //Projede kayıtlı Addresses.txt dosyasının var olup olmadığını test eden kod:
        String userDir = System.getProperty("user.dir");//Projenin yolunu dinamik olarak verir
        System.out.println("userDir = " + userDir);

        boolean isFileExist = Files.exists(Path.of(userDir+"/Addresses.txt"));
        assertTrue(isFileExist);

    }

}