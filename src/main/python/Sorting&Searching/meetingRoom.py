class Solution:
    def canAttendMeetting(self,intervals):

        intervals.sort( key=lambda x : x.start )

        for i in xrange(1, len(intervals)):
            if intervals.start < intervals[i-1].end:
                return False
        return True