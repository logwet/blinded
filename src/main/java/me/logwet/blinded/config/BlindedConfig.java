package me.logwet.blinded.config;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BlindedConfig {
    @NotNull
    private boolean f3Enabled = true;

    @NotNull
    private Boolean recipeBookEnabled = true;

    @NotNull
    private List<UserConfigInventoryItemEntry> inventory;

    public BlindedConfig(@NotNull List<UserConfigInventoryItemEntry> inventory) {
        this.inventory = inventory;
    }

    @NotNull
    public static BlindedConfig fromFixedConfigs(List<InventoryItemEntry> inventory) {
        return new BlindedConfig(inventory
                .stream()
                .map(item -> new UserConfigInventoryItemEntry(item.getName(), item.getPrettySlot()))
                .collect(Collectors.toList()));
    }

    @NotNull
    public Boolean isF3Enabled() {
        return f3Enabled;
    }

    @NotNull
    public Boolean isRecipeBookEnabled() {
        return recipeBookEnabled;
    }

    @NotNull
    public List<UserConfigInventoryItemEntry> getInventory() {
        return inventory;
    }

    @NotNull
    public Map<String, Integer> getItems() {
        return inventory
                .stream()
                .collect(Collectors.toMap(UserConfigInventoryItemEntry::getName, UserConfigInventoryItemEntry::getSlot));
    }

    public boolean matches(List<InventoryItemEntry> uniqueItemsList) {
        Set<String> uniqueItems = uniqueItemsList
                .stream()
                .map(InventoryItemEntry::getName)
                .collect(Collectors.toSet());

        return getInventory().size() == uniqueItems.size()
                && getInventory()
                .stream()
                .map(UserConfigInventoryItemEntry::getName)
                .allMatch(uniqueItems::contains);
    }
}

