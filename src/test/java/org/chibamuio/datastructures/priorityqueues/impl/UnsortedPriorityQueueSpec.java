package org.chibamuio.datastructures.priorityqueues.impl;

import org.chibamuio.datastructures.priorityqueues.impl.impl.UnsortedPriorityQueue;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UnsortedPriorityQueueSpec<K, V> {


    @Test
    public void priorityQueueEmptyWhenNoEntriesAdded(){

        UnsortedPriorityQueue<K, V> priorityQueue = new UnsortedPriorityQueue<K, V>();
       // priorityQueue.insert()
        String s = "";
        String[] timeSegments = s.split(":");


    }
}
