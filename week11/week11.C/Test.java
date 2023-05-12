import java.util.*;

public class Test {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        List<PhoneBook.PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);
        
        List<PhoneBook.PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

        Collection<PhoneBook.PhoneNumber> claraList = new ArrayList<>();
        claraList.add(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.MOBILE, "23424279"));
        phoneBook.addNewPhoneNumbers("Clara", claraList);
        Collection<PhoneBook.PhoneNumber> paulList = new ArrayList<>();
        paulList.add(new PhoneBook.PhoneNumber(PhoneBook.PhoneNumberType.WORK, "56756335"));
        phoneBook.addNewPhoneNumbers("Paul", paulList);
        
        phoneBook.printPhoneBook();
    }
}
