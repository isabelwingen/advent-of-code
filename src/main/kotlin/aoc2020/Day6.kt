package aoc2020

import getResourceAsList
import splitBy

private fun parseInput11(path: String, connect: (a: List<String>) -> Set<Char>): List<Set<Char>> {
   return getResourceAsList(path)
       .splitBy { it.isBlank() }
       .filter { line -> line.all { it.isNotBlank() } }
       .map { group -> connect(group) }
}

private fun intersectGroup(lines: List<String>): Set<Char> {
    return lines
        .map { it.toSet() }
        .reduceRight { a, b -> a.intersect(b)}
}

private  fun joinGroup(lines: List<String>): Set<Char> {
    return lines
        .map { it.toSet() }
        .reduceRight { a, b -> a.union(b)}
}

fun executeDay6Part1(name: String = "day6.txt"): Int {
    return parseInput11(name) { joinGroup(it) }
        .map { it.count() }
        .reduceRight { a, b -> a + b }
}

fun executeDay6Part2(): Int {
    return parseInput11("day6.txt") { intersectGroup(it) }
        .map { it.count() }
        .reduceRight { a, b -> a + b }
}