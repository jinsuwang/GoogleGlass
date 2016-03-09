import time
import datetime
import logging
# logging.setLevel(logging.DEBUG)

class GoogleMapsClient(object):
    """3rd party maps client; we CANT EDIT THIS."""

    def __init__(self):
        self.requests_made = 0

    def make_request(self):
        self.requests_made += 1
        now = datetime.datetime.now().time()
        print "%d - %s - San Francisco" % (self.requests_made, now)
        return "%d - %s - San Francisco" % (self.requests_made, now)

# Version 1, allow burst
class MyRequest(object):
    def __init__(self, limit):
        self.client = GoogleMapsClient()
        self.time = time.time()
        self.request_times = 0
        self.limit = limit

    def make_request(self):
        # reset limit
        if (time.time()-self.time)>1:
            self.time = time.time()
            self.request_times = 0
        if self.request_times >= self.limit: 
            raise Exception("Rate limit")
            time.sleep(1)
        else:
            self.request_times += 1
        print self.request_times, 
        return self.client.make_request()


# Version 2, don't allow burst
class MyRequestNoBurst(object):
    def __init__(self, limit):
        self.client = GoogleMapsClient()
        self.prev_call_t = None
        self.limit =limit

    def make_request(self):
        if self.prev_call_t == None:
            self.prev_call_t = time.time()
        else:
            print time.time() - self.prev_call_t
            if time.time() - self.prev_call_t < (1/self.limit):
                raise Exception("Rate limited!")
            else:
                self.prev_call_t = time.time()
        return self.client.make_request()


class MyRequestSlidingWindow(object):
    def __init__(self, window_period):
        self.client = GoogleMapsClient()
        self.window_period =window_period
        
    def make_request(self):
        pass


mq = MyRequest(10)
for i in range(20):
    mq.make_request()







 
