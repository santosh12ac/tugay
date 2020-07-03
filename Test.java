package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
	public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {
		return wordCounts.
				entrySet().
				stream().
				sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public static HashMap<String, Integer> getHashTagDetails(List<String> data) {
		HashMap<String, Integer> tag = new HashMap<String, Integer>();
		String hashkey;
		int value = 0;

		for (int i = 0; i < data.size(); i++) {
			int hashPosition = data.get(i).indexOf("#");
			if (hashPosition == -1) {
				System.out.println("");
			}

			hashkey = data.get(i).substring(hashPosition - 1 + "#".length());
			if (!tag.containsKey(hashkey)) {
				tag.put(hashkey, 1);
			} else {
				value = tag.get(hashkey);
				value = value + 1;
				tag.put(hashkey, value);
			}
		}
		System.out.println(value);
		System.out.println(tag);
		return tag;
	}

	public static void main(String[] args) {

		List<String> s = new ArrayList<String>();
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam santosh #Sachin1");
		s.add("Hi iam santosh #Sachin1");
		s.add("Hi iam santosh #Sachin");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam santosh #Sachin1");
		s.add("Hi iam santosh1 #Sachin");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam santosh #Sachin1");
		s.add("Hi iam santosh #Sachin");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam santosh #Sachin1");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam FirstTag #Hashtag1");
		s.add("Hi iam FirstTag #Hashtag1");
		Test t = new Test();
		Map<String, Integer> s3 = t.getHashTagDetails(s);
		final Map<String, Integer> sortedByCount = sortByValue(s3);
		List<String> keys = sortedByCount.entrySet().stream().map(Map.Entry::getKey).limit(10)
				.collect(Collectors.toList());
		System.out.println("Hastags are:"+keys);

	}

}
