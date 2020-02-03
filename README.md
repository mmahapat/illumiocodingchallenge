# illumiocodingchallenge


A coding challenge by Illumio

Problem Statement:

Given a set of firewall rules, a network packet will be accepted by the firewall if and only if the direction, protocol, port, and IP address match at least one of the input rules. If a rule contains a port range, it will match all packets whose port falls within the range. If a rule contains an IP address range, it will match all packets whose IP address falls within the range.

Technologies and language:

Programming language - JAVA
Build Tool - Maven
Run command - mvn clean install, mvn -Dtest=Firewall test


Design methodologies:

I have created an IPRange object for each rule and mapped it in an IPTree. The IPTree is a TreeMap sorted on the start of the range (long integer).

A hashmap of port and IPTree is used to store the data.
To validate a rule,the relevant Iptree is matched against the port.
All Ip ranges beyond the range are discarded.
Then we interate through the minimized seach space searching for an iprange that includes the given range.
If found we check if Direction and Protocol rule is satisfied.

Testing:

I also tested by generating a large file.
i dededuced that when input is inclined towards including a lot of port ranges testcases, my solution is not optimal

Drawback:

Since i have created an IPtree for each port which increases time and space complexity.
A similar tree structure for port ranges can be done.
Currently the solution is optimal incase there are less port ranges.

Team Preferences:

Inorder of Preference : Platform , Policy and Data.
