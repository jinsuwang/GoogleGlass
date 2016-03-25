class Solution:

    def romanToInt(self, s):
        roman_map = {
            "I" : 1,
            "V" : 5,
            "X" : 10,
            "L" : 50, 
            "C" : 100,
            "D" : 500,
            "M" : 1000
        }

        ret = 0
        for i in range(len(s)):
            if i > 0 and roman_map[s[i]] > roman_map[s[i-1]]:
                ret += roman_map[s[i]] - 2 * roman_map[s[i-1]]
            else:
                ret += roman_map[s[i]]

        return ret
        