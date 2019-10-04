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
        return items.stream().sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
    }

    @Override
    protected List<Item> sortOnCostFromLestToMostExpensiveAllItemsThatCostLessThanOrEqualToMyMonies(List<Item> items, int monies) {
        return items.stream()
                .filter(i -> i.getCost() <= monies)
                .sorted(Comparator.comparing(Item::getCost))
                .collect(Collectors.toList());
    }

    @Override
    protected Item getTheItemWithTheMostCost(List<Item> items) {
        return items.stream().max(Comparator.comparing(Item::getCost)).orElseThrow();
    }

    @Override
    protected int getTheAverageCostRoundedDown(List<Item> items) {
        return items.stream().mapToInt(x -> x.getCost()).sum() / items.size();
    }

    @Override
    protected void addAllItemsToMyMapWIthKetNameAndValueOfCost(List<Item> items, Map<String, Integer> myMap) {
        items.stream().forEach(e -> myMap.put(e.getName(), e.getCost()));
    }
}
