# Italian Delight

## Notes for Remake
Brewin and Chewin 1.20.1 uses an updated fluid system, every drink should have a fluid object <br>
BnC BoozeItem() no longer default applies the Tipsy effect, and needs to be manually added in the FoodProperties definition <br>
Pizzas extend the default BnC Pizza item <br>

Ciambellone + Pandoro + Panettone | extends Block <br>
Blockstate Bites/Slices tracks how many slices have been eaten <br>
Block should have use() method that checks for holding a knife <br>
if held knife drop item <br>
else consume slice <br>

WoodenOven is BlockEntity <br>
WoodenOven uses the Smoker RecipeType <br>
WoodenOven needs a recipe or full removal (your choice) <br>
uses Smoker GUI <br>

Farmers Delight offers the WildCropConfiguration for doing worldgen with wild crops in the ConfiguredFeatures class <br>
BiomeModifers target Features to add to specific biomes <br>
Olive + Wild Herbs | Plains, Wild Grapes | Jungle <br>
OliveTreeGrower extends AbstractTreeGrower <br>

World Gen
- AbstractTreeGrower
- ConfiguredFeatures, TreeConfigurationBuilder, WildCropConfiguration
- PlacedFeatures, registers ConfiguredFeature
- BiomeModifiers, registers PlacedFeatures, maps them to biomes

Tags <br> 
Not fully inclusive
- forge:raw_meat
  - raw_salami
- forge:cooked_salami
  - cooked_salami
- forge:seeds/grapes
    - grape_seeds
- forge:seeds/herb_leaves
    - herb_leaves
- forge:crops
  - grapes
  - herb_leaves

- brewinandchewin:pizza_toppings
  - salami_slice
- brewinandchewin:fermented_drinks
  - sweetberry_wine
  - glowberry_wine
  - rose_wine
  - hasting_wine
  - hellhound_wine
  - dragonborn_wine
  - spumante

- farmersdelight:wild_crops
  - wild_grapes
  - wild_herbs
- farmersdelight:drinks
    - sweetberry_wine
    - glowberry_wine
    - rose_wine
    - hasting_wine
    - hellhound_wine
    - dragonborn_wine
    - spumante