const side_quests_data = [
  {
    id: "bring_fish_for_karin",
    type: "side",
    preDialogCount: 3,
    objectives: [
      {
        type: "collect_item",
        item: "dbe:giant_fish",
        count: 5
      },
      {
        type: "interact_npc",
        entity: "dbe:korin",
        dialog_count: 3
      }
    ],
    rewards: [
      {
        type: "item",
        item: "dbe:flying_nimbus"
      }
    ]
  },
  {
    id: "fetch_bulma_outfit",
    type: "side",
    preDialogCount: 3,
    objectives: [
      {
        type: "collect_item",
        item: "dbe:bunny_costume_ears"
      }
    ],
    rewards: [
      {
        type: "item",
        item: "dbe:power_pole"
      }
    ]
  },
  {
    id: "pirate_robot_treasure",
    type: "side",
    preDialogCount: 3,
    objectives: [
      {
        type: "enter_biome",
        biome: "minecraft:beach"
      },
      {
        type: "kill_enemy",
        entity: "dbe:pirate_robot",
        spawn_on_start: true
      },
      {
        type: "dialog",
        dialog_count: 3
      }
    ],
    rewards: [
      { type: "training_points" },
      { type: "item", item: "dbe:katana" },
      { type: "item", item: "dbe:nanochip", amount: 2 },
      { type: "item", item: "dbe:evolitium_crystal", amount: 6 },
      { type: "item", item: "minecraft:iron_ingot", amount: 8 },
      { type: "z_points" },
      { type: "zeni" }
    ]
  },
  {
    id: "train_with_goku",
    type: "side",
    preDialogCount: 3,
    objectives: [
      {
        type: "kill_enemy",
        entity: "dbe:goku_enemy",
        spawn_on_start: true,
        entity_definitions: {
          attributes: {
            total: 360,
            focus: {
              constitution: 1,
              dexterity: 2,
              spirit: 3,
              strength: 2
            }
          },
          available_transformations: [
            "base",
            "ssj"
          ]
        }
      }
    ],
    rewards: [
      { type: "alignment_question" },
      { type: "item", item: "dbe:goku_chestplate" },
      { type: "item", item: "dbe:goku_leggings" },
      { type: "item", item: "dbe:goku_boots" },
      { type: "z_points" }
    ]
  },
  {
    id: "visit_lookout",
    type: "side",
    autoStart: true,
    preDialogCount: 3,
    objectives: [
      {
        type: "enter_region",
        region: "lookout"
      },
      {
        type: "interact_npc",
        entity: "dbe:korin",
        dialog_count: 3
      }
    ],
    rewards: [
      { type: "training_points" },
      { type: "z_points" }
    ]
  },
  {
    id: "whis_meat_fish_delivery",
    type: "side",
    preDialogCount: 4,
    objectives: [
      {
        type: "collect_item",
        item: "dbe:cooked_dinosaur_meat",
        count: 6
      },
      {
        type: "collect_item",
        item: "dbe:cooked_giant_fish",
        count: 2
      },
      {
        type: "interact_npc",
        entity: "dbe:whis",
        dialog_count: 3
      }
    ],
    rewards: [
      { type: "training_points" },
      { type: "z_points" }
    ]
  }
];
export {
  side_quests_data
};
