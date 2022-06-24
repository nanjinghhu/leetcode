package com.alhata.leetcode.string;

import java.util.*;

/**
 * // The people who buy ads on our network don't have enough data about how ads are working for
 * //their business. They've asked us to find out which ads produce the most purchases on their website.
 *
 * // Our client provided us with a list of user IDs of customers who bought something on a landing page
 * //after clicking one of their ads:
 *
 * // # Each user completed 1 purchase.
 * // completed_purchase_user_ids = [
 * //   "3123122444","234111110", "8321125440", "99911063"]
 *
 * // And our ops team provided us with some raw log data from our ad server showing every time a
 * //user clicked on one of our ads:
 * // ad_clicks = [
 * //  #"IP_Address,Time,Ad_Text",
 * //  "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
 * //  "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
 * //  "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
 * //  "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
 * //  "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
 * //  "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens",
 * //]
 *
 * //The client also sent over the IP addresses of all their users.
 *
 * //all_user_ips = [
 * //  #"User_ID,IP_Address",
 * //   "2339985511,122.121.0.155",
 * //  "234111110,122.121.0.1",
 * //  "3123122444,92.130.6.145",
 * //  "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
 * //  "8321125440,82.1.106.8",
 * //  "99911063,92.130.6.144"
 * //]
 *
 * // Write a function to parse this data, determine how many times each ad was clicked,
 * //then return the ad text, that ad's number of clicks, and how many of those ad clicks
 * //were from users who made a purchase.
 *
 *
 * // Expected output:
 * // Bought Clicked Ad Text
 * // 1 of 2  2017 Pet Mittens
 * // 0 of 1  The Best Hollywood Coats
 * // 3 of 3  Buy wool coats for your pets
 */
public class KaratAdsConversionRate {
    public static void main(String[] args) {
        String[]  completed_purchase_user_ids = {"3123122444","234111110", "8321125440", "99911063"};

        String[]  ad_clicks = new String[]{
                "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens",
        };

        String[] all_user_ips = {
                "2339985511,122.121.0.155",
                "234111110,122.121.0.1",
                "3123122444,92.130.6.145",
                "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
                "8321125440,82.1.106.8",
                "99911063,92.130.6.144"
        };

        System.out.println(Arrays.toString(calculateAdsConversionRate(completed_purchase_user_ids, all_user_ips, ad_clicks).toArray()));
    }

    public static List<String> calculateAdsConversionRate(String[] boughtUserIds, String[] userIps, String[] ipAdsClicks) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> adsClicksMap = new HashMap<>();
        Map<String, String> ipAdsMap = new HashMap<>();
        Map<String, String> userIpMap = new HashMap<>();
        Map<String, Integer> adsBoughtMap = new HashMap<>();
        for(String ipAdsClick: ipAdsClicks) {
            String[] ipTimeAds = ipAdsClick.split(",");
            ipAdsMap.put(ipTimeAds[0], ipTimeAds[2]);
            adsClicksMap.put(ipTimeAds[2], adsClicksMap.getOrDefault(ipTimeAds[2], 0) + 1);
        }
        for(String userIp : userIps) {
            String[] userIpSplit = userIp.split(",");
            userIpMap.put(userIpSplit[0], userIpSplit[1]);
        }

        for(String userId: boughtUserIds) {
            adsBoughtMap.put(ipAdsMap.get(userIpMap.get(userId)/*ip*/), adsBoughtMap.getOrDefault(ipAdsMap.get(userIpMap.get(userId)/*ip*/), 0) + 1);
        }

//        adsBoughtMap.forEach((k, v)-> System.out.println(k + ":" + v));
//        adsClicksMap.forEach((k, v) -> System.out.println(k + ":" + v));

        for(Map.Entry<String, Integer> entry: adsClicksMap.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(adsBoughtMap.get(entry.getKey()) == null ? "0" : adsBoughtMap.get(entry.getKey()).toString())
                    .append(" of ")
                    .append(entry.getValue().toString())
                    .append(" ")
                    .append(entry.getKey());
            res.add(stringBuilder.toString());

        }
        return res;
    }
}
