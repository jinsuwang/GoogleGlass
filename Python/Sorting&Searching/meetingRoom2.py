class Solution:
    def minMeetingRooms(self, intervals):
        starts, ends = [], []
        for i in intervals:
            starts.append(i.start)
            ends.append(i.end)

        starts.sort()
        ends.sort()

        s, e = 0 , 0
        min_rooms, cnt_rooms = 0 , 0
        while s < len(starts):
            if starts[s] < ends[e]:
                cnt_rooms += 1
                min_rooms = max(min_rooms, cnt_rooms)
                s += 1
            else:
                cnt_rooms -= 1
                e += 1
        return min_rooms