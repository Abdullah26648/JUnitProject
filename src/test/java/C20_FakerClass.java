import com.github.javafaker.Faker;
import org.junit.Test;

public class C20_FakerClass {
    //Java Faker: Sahte data üretmek için kullanılır.

    @Test
    public void fakerClassTest(){
        //Faker objesi oluştur
        Faker faker = new Faker();

        //Objeyi kullanarak fake data üret
        //firstname
        String firstname = faker.name().firstName();
        System.out.println("firstname = " + firstname);

        //lastname
        String lastname = faker.name().lastName();
        System.out.println("lastname = " + lastname);

        //full name
        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        System.out.println("faker.name().title() = " + faker.name().title());

        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());

        System.out.println("faker.address().city() = " + faker.address().city());

        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());

        System.out.println("Faker.instance().animal().name() = " + Faker.instance().animal().name());
        //Faker.instance() static methodu ile obje oluşturmadan data üretilebilir

        System.out.println("faker.funnyName().name() = " + faker.funnyName().name());

        System.out.println("faker.internet().emailAddress() = " + faker.internet().emailAddress());

        System.out.println("faker.internet().password() = " + faker.internet().password());

        System.out.println("faker.date().birthday() = " + faker.date().birthday());

        System.out.println("faker.number().numberBetween(4,7) = " + faker.number().numberBetween(4, 7));

        System.out.println("faker.lorem().sentence() = " + faker.lorem().sentence());

        System.out.println("faker.lordOfTheRings().character() = " + faker.lordOfTheRings().character());

    }

}
