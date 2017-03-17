class Solution:

	def find_interval(interval, center, radius):
		start = interval[0]
		end = interval[1]

		if center+radius < end and center-radius > start:
			return (center-radius, center+radius)
	
