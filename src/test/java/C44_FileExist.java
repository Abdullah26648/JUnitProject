import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class C44_FileExist {
/*
    Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
    Java da dosyay erismek icin dosya yoluna -pathine ihitiyacimiz vardir
    Her bilgisayarin kullanici adi farkli olacagindan masaustu dosya yolu da birbirinden farkl, olacaktir..
    Testlerimizin tum bilgisayarda calismasi icin dosya yolunu DİNAMİK yapmak zorundayiz..

    Files.exists(Paths.get (filePath)); Bilgisayarınızda dosyanın olup olmadığını kontrol eder.
*/
    @Test
    public void test01() {

        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);


        boolean isFileExist = Files.exists(Path.of(userHome+"/OneDrive/Masaüstü/Flower.bmp"));
        assertTrue("File does not exist", isFileExist);

    }
}
