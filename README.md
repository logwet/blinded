# Blinded

## About

When you create a new world, you will spawn in the overworld at a portal at post blind coords (radius 1200-1800).
Your inventory contains a set of standard post blind items you would have in a usual hypermodern RSG situation where
you did bastion trades. Beat the dragon and reach the credits as usual.

![educated inventory](assets/educated_inventory.png)

_An example inventoy generated under the default config._  
__Note that many of the items in the inventory have randomised counts.
Refer to [`fixed_config.json`](src/main/resources/fixed_config.json) for the random distributions.__

You cannot customise the number, type or durability of the items in your inventory but you can adjust what slot they're in.
You do this through editing `.minecraft/config/blinded-X.X.X.json`.

_(At the moment the slot of non-unique items, eg. multiple beds or ender pearls (if there are more than one stack in the inv),
are not changeable. This may change in the future.)_

```json
{
  "f3Enabled": true,
  "recipeBookEnabled": true,
  "inventory": [
    {
      "name": "WOODEN_AXE",
      "slot": 1
    },
    ...
    {
      "name": "BREAD",
      "slot": 41
    }
  ]
}
```

![inventory_mapping](assets/inventory_mapping.png)

_The slots to inventory mapping. ie. if you want to put something in the hotbar, use slot 41._

Every new release of blinded will create a new config file, so if you want to use your slot config from the previous
version copy it over. This is to allow players to easily use different releases of the mod
at the same time without having to delete their config file every time.

Before you join a new world the mod saves your render distance and FOV, and resets to this after you leave the world.
_ie. this means you can configure the RD and FOV you will always spawn with by changing it in the main menu, and you
don't have to reset these settings to your preferred defaults in between runs._

Depending on the version you are using the f3 menu will be automatically opened for you.

When you spawn your yaw (facing angle) is randomised. The y height of the portal the mod attempts to target is also
randomly determined using a different distribution per release. You can see this distribution in
[`fixed_config.json`](src/main/resources/fixed_config.json) _(Make sure to switch to the right branch)_

All random values in the mod are deterministically derived from your world seed, meaning creating a world with the same
seed will yield the same yaw and targeted y height. Therefore, the mod is suitable for SSG

## Support

If you have a problem with the mod, a question or experience a crash follow these steps:
1. Check the README to see if there's any relevant info on there, particularly the FAQ section.
2. Check the GitHub Issues (including closed issues).
3. Check the GitHub Releases to see if a newer build has been released that addresses your problem.
4. If you're experiencing a crash, make a GitHub issue and include the crash report.
5. If none of the above steps are helpful, DM me on discord (I'm in HBG Hub, Javacord etc. under this name).

## FAQ

- Is this mod compatible with Noverworld
  - For what I hope are obvious reasons, no, it is not compatible at all, and probably will crash.
- How do I download the mod?
  - The [releases](https://github.com/logwet/blinded/releases/) page on this GitHub repo.
- What file do I download? There's a bunch.
  - Then download the release version of the mod ie. `blinded-x.x.x.jar` instead of `blinded-x-x-x-dev.jar` and put it in your mods folder.
- How do I change the hotbar/inventory?
  - Using the config file at `.minecraft/config/blinded-X.X.X.json`.
- How do I change what items are in my hotbar/inventory?
  - You can't easily do so. The three blinded categories have fixed inventories, you can change the slots your items are in but not their type, durability or count.
  - If you __really__ want to change the items, you can do so by editing `fixed_config.json` and recompiling the mod, but beware that this will make your runs unverifiable for the leaderboards.
- How do I reset my hotbar to the default included in the mod?
  - Delete the config file at `.minecraft/config/blinded-X.X.X.json`. When you create a new world or reload the game the defaults will be applied.
- I updated the mod and my inventory slot config has been reset, what gives?
  - Every new version of the mod writes a new file, just copy your settings over. Read above for an explanation of why.
- How do I set my FOV and render distance default?
  - Edit those values in the game's main menu (ie. outside of a world) and they'll be saved.
- I want to run blinded without f3
  - Set `f3Enabled` to `false` in the config file. This won't automatically open f3 before you spawn.
- I don't book craft so I don't want the recipe book to be automatically opened by default.
  - Set `recipeBookEnabled` to `false` in the config file. This won't automatically open the recipe book pane before you spawn.
- I have a suggestion for improvement.
  - Make a GitHub issue and include as much information as you can.
  - Or message me on Discord.
- The mod is crashing while launching with `java.lang.reflect.InvocationTargetException`
  - Make sure you are running the release version of the mod ie. `blinded-x.x.x.jar` instead of `blinded-x-x-x-dev.jar`
- Is this incompatible with any mods:
  - This mod has been tested and confirmed to work with:
    - Sodium
    - Lithium
    - Starlight
    - FastReset (doesn't save world)
    - AutoReset (automatically reset worlds w/o macro) ___note: some users have reported problems with this mod___
    - LazyDFU
    - Moonlight (threaded stronghold gen)
  - I will not support multi-threaded world gen such as C2ME. Perhaps sometime in the future as a separate branch.

Contributions are welcome. This mod is licensed under the GPL-3.0, meaning any forks/derivative works must also be open
source and licensed under the GPL-3.0. If you fork the mod and publish the distribution (without the intention of
merging your changes upstream) please change the name from Blinded to a suitably distinct alternative to avoid confusion.
