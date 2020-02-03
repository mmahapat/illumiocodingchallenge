package org.illumio.assignment.illumiocodingchallenge;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

public class IPTree {

	private TreeMap<IPRange, IPDirection_Protocol> iptreemap;

	public IPTree() {
		iptreemap = new TreeMap<>();
	}

	public void insert(String ipString, IPDirection_Protocol rule) {
		IPRange range = new IPRange(ipString);
		IPDirection_Protocol existingRule = iptreemap.get(range);
		if (existingRule != null) {

			existingRule.addDirection_Protocol(rule);
			iptreemap.put(range, existingRule);
		} else {

			iptreemap.put(range, rule);
		}
	}

	public boolean isAllowed(String ip, String direction, String protocol) {
		long ipLong = IPRange.ipToLong(ip);

		NavigableMap<IPRange, IPDirection_Protocol> map = iptreemap.headMap(new IPRange(ipLong + 1, ipLong + 1), false);

		NavigableSet<IPRange> descendKeySet = map.descendingKeySet();
		Iterator<IPRange> descendIter = descendKeySet.iterator();
		while (descendIter.hasNext()) {
			IPRange next = descendIter.next();
			if (next.contains(ipLong)) {

				if (iptreemap.get(next).checkifAllow(direction, protocol))

					return true;

			}
		}
		return false;
	}

	
}
