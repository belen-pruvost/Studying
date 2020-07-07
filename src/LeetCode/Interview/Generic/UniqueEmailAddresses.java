package LeetCode.Interview.Generic;

import java.util.HashSet;

public class UniqueEmailAddresses {
  public int numUniqueEmails(String[] emails) {
    if(emails == null || emails.length == 0) {
      return 0;
    }
    HashSet<String> actualEmails = new HashSet<>();
    for(String email : emails) {
      String parsedEmail = parseEmail(email);
      if(!actualEmails.contains(parsedEmail)) {
        actualEmails.add(parsedEmail);
      }
    }
   return actualEmails.size();
  }

  private String parseEmail(String email) {
    int atIndex = email.indexOf("@");
    String domain = email.substring(atIndex);
    StringBuilder name = new StringBuilder();
    char[] nameContent = email.substring(0, atIndex).toCharArray();
    for(int i = 0; i < nameContent.length; i++) {
      if(nameContent[i] == '.') {
        continue;
      }
      if(nameContent[i] == '+') {
        break;
      }
      name.append(nameContent[i]);
    }
    name.append("@");
    name.append(domain);
    return name.toString();
  }
}

class TestUniqueEmailAddresses{
  public static void main (String[] args) {
    UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
    String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
    System.out.println(uniqueEmailAddresses.numUniqueEmails(emails));
  }
}
