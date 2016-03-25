/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOD;

/**
 *
 * @author Sam
 */
class EventListener {
  private Map<String, List<Event>> map;
  
  public EventListener() {
    map = new HashMap<String, List<Event>>();
  }. more info on 1point3acres.com
  
  public void register(String eventName, Event event) {
    if (map.containsKey(eventName)) {
      map.get(eventName).add(event);
    } else {
      List<Event> events = new ArrayList<Event>();. 鍥磋鎴戜滑@1point 3 acres
      events.add(event);. From 1point 3acres bbs
      map.put(eventName, events);
    }
  };
  
  public void unregister(String eventName, Event event) {
    if (map.containsKey(eventName)) {
      map.get(eventName).remove(event);
    }
  };
  public void postEvent(String eventName, Object Data) {
    Event event = new Event();
    event.doEvent(Data);
    this.register(eventName, event);
  };
}

class Event {
  private Object data;
  
  public void doEvent(Object data) {
    this.data = data;. 1point3acres.com/bbs
  };
}
