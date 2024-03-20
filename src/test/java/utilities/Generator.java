package utilities;

import static utilities.Constants.Time.GMAIL_DOMAIN;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
  private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static String generateRandomString(int length) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomIndex = random.nextInt(CHARACTERS.length());
      sb.append(CHARACTERS.charAt(randomIndex));
    }
    return sb.toString();
  }

  public static String generateRandomString(int length, String characterString) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomIndex = random.nextInt(characterString.length());
      sb.append(characterString.charAt(randomIndex));
    }
    return sb.toString();
  }

  public static String generateRandomString(int minLength, int maxLength) {
    Random random = new Random();
    int length = minLength + random.nextInt(maxLength - minLength + 1);
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int randomIndex = random.nextInt(CHARACTERS.length());
      sb.append(CHARACTERS.charAt(randomIndex));
    }
    return sb.toString();
  }

  public static int generateRandomInt(int min, int max) {
    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }

  public static String generateRandomEmail(int minLength, int maxLength) {
    return (generateRandomString(minLength, maxLength) + GMAIL_DOMAIN).toLowerCase();
  }

  public static String generateRandomDate(int startYear, int endYear) {
    LocalDate randomDate = generateRandomDateObject(startYear, endYear);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    return randomDate.format(formatter);
  }

  private static LocalDate generateRandomDateObject(int startYear, int endYear) {
    int year = ThreadLocalRandom.current().nextInt(startYear, endYear + 1);
    int month = ThreadLocalRandom.current().nextInt(1, 13);
    int day =
        ThreadLocalRandom.current().nextInt(1, LocalDate.of(year, month, 1).lengthOfMonth() + 1);
    return LocalDate.of(year, month, day);
  }

  public static String getCurrentDate() {
    LocalDate currentDate = LocalDate.now();
    return currentDate.toString();
  }

  public static String getCurrentDate(String pattern) {
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return currentDate.format(formatter);
  }

  public static <T> T getRandomElement(List<T> list) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException("List cant be null or empty");
    }
    Random random = new Random();
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }
}
