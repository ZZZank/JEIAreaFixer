# Changelog

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
