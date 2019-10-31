class Solution {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
            return "IPv4";
        }
        if (isValidIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    
    private boolean isValidIPv6(String IP) {
        String[] sp = IP.split("\\:");
        if (sp.length != 8) {
            return false;
        }
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        for (String s : sp) {
            if (s.length() < 1) {
                return false;
            }
            char[] arr = s.toCharArray();
            if (arr.length > 4) {
                return false;
            }
            for (char c : arr) {
                if (!((c - '0' <= 9 && c - '0' >= 0) || (c - 'a' <= 5 && c - 'a' >= 0) || (c - 'A' <= 5 && c - 'A' >= 0))) {
                    //System.out.println(s + " " + c + " " + (c - '0'));
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidIPv4(String IP) {
        String[] sp = IP.split("\\.");
        if (sp.length != 4) {
            return false;
        }
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        for (String s : sp) {
            if (s.length() < 1) {
                return false;
            }
            if (s.charAt(0) == '0' && s.length() > 1) {
                return false;
            }
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (!(c - '0' <= 9 && c - '0' >= 0)) {
                    return false;
                }
            }
            try {
                int i = Integer.parseInt(s);
                if (i < 0 || i > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}