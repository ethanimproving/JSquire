package kihons;

import framework.Item;
import framework.bases.StreamsKihonBase;
import framework.exceptions.NotImplementedYetException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamKihon extends StreamsKihonBase {

    @Override
    protected List<String> getTheNamesOfAllItems(List<Item> items) {
        return items.stream().map(s -> s.getName()).collect(Collectors.toList());
    }

    @Override
    protected List<Item> sortItemsAlphabeticallyBasedOnName(List<Item> items) {
        return items.stream().sorted(Comparator.comparing(s -> s.getName())).collect(Collectors.toList());
    }

    @Override
    protected List<Item> sortOnCostFromLestToMostExpensiveAllItemsThatCostLessThanOrEqualToMyMonies(List<Item> items, int monies) {
        throw new NotImplementedYetException();
    }

    @Override
    protected Item getTheItemWithTheMostCost(List<Item> items) {
        return items.stream().max(Comparator.comparing(s -> s.getCost())).get();
    }

    @Override
    protected int getTheAverageCostRoundedDown(List<Item> items) {
        return (int)items.stream().mapToInt((s) -> s.getCost()).summaryStatistics().getAverage();
    }

    @Override
    protected void addAllItemsToMyMapWIthKetNameAndValueOfCost(List<Item> items, Map<String, Integer> myMap) {
        items.stream().collect(Collectors.toMap(Function.identity(), s -> {
            return s;
        }));
    }
}
