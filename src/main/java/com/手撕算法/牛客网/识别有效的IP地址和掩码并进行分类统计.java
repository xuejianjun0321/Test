package com.手撕算法.牛客网;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 *
 * 所有的IP地址划分为 A,B,C,D,E五类
 *
 * A类地址从1.0.0.0到126.255.255.255;
 *
 * B类地址从128.0.0.0到191.255.255.255;
 *
 * C类地址从192.0.0.0到223.255.255.255;
 *
 * D类地址从224.0.0.0到239.255.255.255；
 *
 * E类地址从240.0.0.0到255.255.255.255
 *
 *
 * 私网IP范围是：
 *
 * 从10.0.0.0到10.255.255.255
 *
 * 从172.16.0.0到172.31.255.255
 *
 * 从192.168.0.0到192.168.255.255
 *
 *
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * （注意二进制下全是1或者全是0均为非法子网掩码）
 *
 * 注意：
 * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 */
public class 识别有效的IP地址和掩码并进行分类统计 {
    private static final String INVALID_ALL_1 = "255.255.255.255";
    private static final String ZERO_TO_255 = "(\\d{1,2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])";
    private static final String FORMAT_255 = ZERO_TO_255 + "\\." + ZERO_TO_255 + "\\." + ZERO_TO_255 + "\\." + ZERO_TO_255;

    public static void main(String[] args) throws IOException {
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0, eCount = 0,
                failCount = 0, privCount = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            String[] line = str.split("~");

            // 首先判断非法ip
            if (!isValidIp(line[0])) {
                ++failCount;
                continue;
            }

            // 解析ip地址数值
            String[] ipAddress = line[0].split("\\.", -1);
            int[] ip = new int[ipAddress.length];
            for (int i = 0; i < ipAddress.length; ++i) {
                ip[i] = Integer.parseInt(ipAddress[i]);
            }
            // 然后忽略【0.*.*.*】和【127.*.*.*】的IP地址
            if (ip[0] == 0 || ip[0] == 127) {
                continue;
            }

            // 接着是非法掩码
            if (!isValidMask(line[1])) {
                ++failCount;
                continue;
            }

            // 判断a, b, c, d, e五类地址
            if (ip[0] >= 1 && ip[0] <= 126) {
                ++aCount;
            }
            if (ip[0] >= 128 && ip[0] <= 191) {
                ++bCount;
            }
            if (ip[0] >= 192 && ip[0] <= 223) {
                ++cCount;
            }
            if (ip[0] >= 224 && ip[0] <= 239) {
                ++dCount;
            }
            if (ip[0] >= 240 && ip[0] <= 255) {
                ++eCount;
            }

            // 判断私有地址
            if (ip[0] == 10) {
                ++privCount;
            }
            if (ip[0] == 172 && ip[1] >= 16 && ip[1] <= 31) {
                ++privCount;
            }
            if (ip[0] == 192 && ip[1] == 168) {
                ++privCount;
            }
        }

        System.out.printf("%d %d %d %d %d %d %d", aCount, bCount, cCount, dCount, eCount, failCount, privCount);
    }

    public static boolean isValidIp(String ip) {
        if (ip.equals(INVALID_ALL_1)) {
            return false;
        }

        if (!ip.matches(FORMAT_255)) {
            return false;
        }

        return true;
    }

    public static boolean isValidMask(String mask) {
        if (mask.equals(INVALID_ALL_1)) {
            return false;
        }

        if (!mask.matches(FORMAT_255)) {
            return false;
        }

        String[] mp = mask.split("\\.", -1);
        int target = 0, count = 3;
        for (int i = 0; i < mp.length; ++i, --count) {
            target = target | Integer.parseInt(mp[i]) & 0xFF;
            if (count > 0) {
                target <<= 8;
            }
        }
        if (Integer.bitCount(~target + 1) != 1) {
            return false; // 中间不能有0
        }
        return true;
    }
}
