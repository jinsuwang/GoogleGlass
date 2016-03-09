import sys
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        tmp = [sys.maxint] * (amount+1)
        tmp[0] = 0
        for i in xrange(amount+1):
            if tmp[i] != sys.maxint:
                for coin in coins:
                    if i+coin <= amount:
                        tmp[i+coin] = min(tmp[i+coin], tmp[i]+1)
        return tmp[amount] if tmp[amount] !=  sys.maxint else -1
