# Changelog

## JEIAreaFixer 1.5.0 -> 1.6.0

perf++ & support 10 more mods

- TinkerIO support
- BlueSkies support
- Crafting Tweaks support
    - the same applies to Crafting Tweaks Unofficial
- TrinketAndBaubles support
- AE2WTLib support
    - and its dependents: Wireless Crafting/Pattern/Fluid/Interface Terminal, 5 mods in total
    - and additional support for Wireless Crafting Terminal
- more precise GUI target setting for some button area provider
    - this can prevent calculating areas on GUIs that are guaranteed to not have any buttons of this kind, improving performance
- buttons pre-filtering
    - by filtering out buttons inside gui before converting to area, we can decrease the amount of areas passes to JEI, so performance will be better

---

## JEIAreaFixer 1.4.0 -> 1.5.0

AE2 & ComputerCraft & debug++

- ComputerCraft support
    - aka CC: Tweaked
- AE2 support
    - note that this support will be force-disable when AE2-UEl is installed, more info in config
    - you can disable AE2-UEL detection in the config
- a new config for AE2 that can avoid providing areas that will shift the whole JEI overlay
- a new debug config that enables capturing all JEI exclusion area and draw them onto screen

## JEIAreaFixer 1.3.1 -> 1.4.0

Cyclic & Forestry & MCJtyLib support

- now config options that do require game restart will be marked as `RequiresMcRestart`
- more config comments
- support for Forestry
- support for Cyclic
    - more precisely, the armor slots in extended player inventory
- support for MCJtyLib
    - support for XNet is removed because this patch contains XNet patch
- a new debug option, which can directly draw areas onto the screen, providing a much more intuitive view
- make output format of debug printing a little bit better
- fix a rare case where debug print is not working due to `ConcurrentModificationException`

## JEIAreaFixer 1.2.0 -> 1.3.0

Config++ & Quark and SmelteryIO and Reskillable support

- Support for
    - Quark: Chest Buttons
    - Reskillable: side inventory tabs
    - SmelteryIO: Fuel Controller, Casting machine
- config for this mod is rewritten now, allowing you to toggle patches at both block level and mod level
    - e.g. for XNet, you can now disable patch for `Controller` block, while keeping patch for `Router` block
    - Changing values of normal config entries(that is, all config entries other than `debug$print`) requires MC restart, which is somehow not shown in config menu
    - remember to DELETE old config file so that options from old and new configs will not mix together
- fix config not saving
- added a debug option that can print extra JEI areas into logs

## JEIAreaFixer 1.1.0 -> 1.2.0

Rebranding & OpenMods support

- Rebrand to JEIAreaFixer
- Supports mods made by OpenMods, e.g. OpenBlocks

## BookmarkAreaFixer 1.0.0 -> 1.1.0

Supports Gambling Style

- Gambling Style trading menu support
- and some internal cleanups

## BookmarkAreaFixer 0 -> 1.0.0

The first release

- provides area fixing for 
  - XNet: Controller, Router
  - RFTools: Modular Storage, Storage Scanner
- with a basic config to enable/disable fixes for specific mod
