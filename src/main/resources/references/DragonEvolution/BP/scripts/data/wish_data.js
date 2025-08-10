const wish_data = [
  {
    type: "item",
    name: "dbe:brave_sword"
  },
  {
    type: "item",
    name: "dbe:cooked_dinosaur_meat",
    amount: 256
  },
  {
    type: "item",
    name: "dbe:cooked_giant_fish",
    amount: 256
  },
  {
    type: "item",
    name: "dbe:evolitium_crystal",
    amount: 64
  },
  {
    type: "item",
    name: "dbe:katchin_shard",
    amount: 2
  },
  {
    type: "item",
    name: "dbe:potara_earrings"
  },
  {
    type: "item",
    name: "dbe:power_fruit"
  },
  {
    type: "item",
    name: "dbe:senzu_bean",
    amount: 5
  },
  {
    type: "item",
    name: "minecraft:amethyst_shard",
    amount: 16
  },
  {
    type: "item",
    name: "minecraft:diamond",
    amount: 64
  },
  {
    type: "skill",
    name: "divine_ki",
    requirements: {
      not_skills: ["divine_ki"]
    }
  },
  {
    type: "skill",
    name: "potential_unleashed",
    requirements: {
      not_skills: ["potential_unleashed"],
      race: "namekian"
    }
  },
  {
    type: "tail",
    name: "grow_tail",
    requirements: {
      race: "saiyan"
    }
  }
];
export {
  wish_data
};
