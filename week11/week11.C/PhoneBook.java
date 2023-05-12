import java.util.*;

public class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();
    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        if (nameToPhoneNumbersMap.containsKey(name)) {
            Collection<PhoneNumber> phones = nameToPhoneNumbersMap.get(name);
            phones.addAll(numbers);
            nameToPhoneNumbersMap.put(name, phones);
        } else {
            nameToPhoneNumbersMap.put(name, numbers);
        }
    }
    public void printPhoneBook() {
        Set<String> keys = nameToPhoneNumbersMap.keySet();
        Iterator<String> keysIterator = keys.iterator();
        while(keysIterator.hasNext()) {
            String name = keysIterator.next();
            System.out.println(name.toUpperCase());
            Collection<PhoneNumber> numbers = nameToPhoneNumbersMap.get(name);
            Iterator<PhoneNumber> numberIterator = numbers.iterator();
            while (numberIterator.hasNext()) {
                PhoneNumber number = numberIterator.next();
                System.out.println(number.getType() + ": " + number.getNumber());
            }
        }
    }
    enum PhoneNumberType {
        MOBILE, HOME, WORK,
    }
    static class PhoneNumber {
        private PhoneNumberType type;
        private String number;
        public PhoneNumber(PhoneNumberType type, String number) {
            this.type = type;
            this.number = number;
        }
        public PhoneNumberType getType() {
            return type;
        }
        public String getNumber() {
            return number;
        }

    }
}