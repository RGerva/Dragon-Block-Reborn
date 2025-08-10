const skills_data = [
  {
    type: "ability",
    id: "aura_boost",
    is_passive: false,
    ki_drain: 1,
    price: 500,
    property_id: "dbe:aura_boost",
    available_trainers: [
      "dbe:kami_sama"
    ],
    modifiers: {
      constitution: 1,
      dexterity: 1.5,
      ki_consume: 1,
      size: 1,
      spirit: 1,
      strength: 1
    }
  },
  {
    type: "ability",
    id: "burst_move",
    is_passive: false,
    ki_drain: 1,
    price: 350,
    available_trainers: [
      "dbe:goku",
      "dbe:piccolo"
    ]
  },
  {
    type: "ability",
    id: "divine_ki",
    is_passive: true,
    show_hud_icon: true
  },
  {
    type: "ability",
    id: "friendly_fist",
    is_passive: false,
    price: 20,
    show_hud_icon: true,
    available_trainers: [
      "dbe:kami_sama"
    ]
  },
  {
    type: "ability",
    id: "fly",
    is_passive: false,
    ki_drain: 1,
    price: 350,
    available_trainers: [
      "dbe:goku",
      "dbe:mr_popo"
    ]
  },
  {
    type: "ki_attack",
    id: "genki_dama",
    ki_drain: 5,
    price: 2500,
    available_trainers: [
      "dbe:king_kai"
    ],
    ki_attack_properties: {
      type: "blast",
      base_damage: 15,
      base_scale: 10,
      charge_speed: 0.5,
      explosion_power: 10,
      offset: [0, 4, 0],
      speed: 0.75
    }
  },
  {
    type: "ability",
    id: "gigantification",
    is_passive: false,
    ki_drain: 1,
    price: 200,
    available_trainers: [
      "dbe:piccolo"
    ],
    modifiers: {
      constitution: 1.5,
      dexterity: 0.5,
      ki_consume: 1,
      size: 2,
      spirit: 1,
      strength: 1.5
    },
    requirements: {
      race: ["bio_android", "namekian"]
    }
  },
  {
    type: "ability",
    id: "hakai",
    is_passive: true,
    price: 16e4,
    show_hud_icon: true,
    available_trainers: [
      "dbe:beerus"
    ],
    aura_properties: {
      ki_bar_color: "purple"
    },
    leveling: {
      cost_per_level: 25e3,
      max: 2,
      modifier_multiplier: 1.2
    },
    modifiers: {
      constitution: 1,
      dexterity: 1,
      ki_consume: 1,
      size: 1,
      spirit: 1.2,
      strength: 1.2
    },
    requirements: {
      not_skills: ["ultra_instinct"]
    }
  },
  {
    type: "ability",
    id: "instant_transmission",
    is_passive: false,
    available_trainers: [
      "dbe:goku"
    ]
  },
  {
    type: "ability",
    id: "kaioken",
    is_passive: false,
    price: 1500,
    show_hud_icon: true,
    available_trainers: [
      "dbe:king_kai"
    ],
    leveling: {
      cost_per_level: 400,
      max: 5
    }
  },
  {
    type: "ki_attack",
    id: "kamehameha",
    can_move_while_firing: true,
    ki_drain: 2,
    price: 800,
    available_trainers: [
      "dbe:master_roshi"
    ],
    ki_attack_properties: {
      type: "beam",
      base_damage: 6,
      base_scale: 4,
      explosion_power: 6,
      offset: [4, 1, 0],
      speed: 0.6
    }
  },
  {
    type: "ki_attack",
    id: "ki_blast",
    can_move_while_firing: true,
    ki_drain: 1,
    price: 200,
    available_trainers: [
      "dbe:goku",
      "dbe:master_roshi",
      "dbe:piccolo"
    ],
    ki_attack_properties: {
      type: "blast",
      base_damage: 1.9,
      charge_speed: 10,
      explosion_power: 4,
      offset: [1, 1.375, -0.375]
    }
  },
  {
    type: "ki_attack",
    id: "kienzan",
    ki_drain: 2,
    price: 200,
    available_trainers: [
      "dbe:krillin"
    ],
    ki_attack_properties: {
      type: "disc",
      base_damage: 2,
      base_scale: 2,
      can_cut_tail: true,
      charge_speed: 2,
      offset: [0, 2, -0.375],
      speed: 3
    }
  },
  {
    type: "weapon",
    id: "ki_scythe",
    base_damage: 2,
    ki_drain: 2,
    price: 1200,
    property_id: "dbe:ki_scythe",
    available_trainers: [
      "dbe:whis"
    ]
  },
  {
    type: "ability",
    id: "ki_sense",
    is_passive: true,
    price: 600,
    available_trainers: [
      "dbe:mr_popo"
    ]
  },
  {
    type: "ability",
    id: "legendary",
    is_passive: true,
    property_id: "dbe:is_legendary",
    show_hud_icon: true,
    aura_properties: {
      ki_bar_color: "green",
      color: {
        red: 57,
        green: 237,
        blue: 8
      }
    },
    modifiers: {
      constitution: 1,
      dexterity: 1.4,
      ki_consume: 1,
      size: 1.1,
      spirit: 1,
      strength: 1.4
    },
    requirements: {
      race: "saiyan"
    }
  },
  {
    type: "ability",
    id: "metamoran_dance",
    is_passive: false,
    price: 16e3,
    available_trainers: [
      "dbe:piccolo"
    ]
  },
  {
    type: "ability",
    id: "potential_unleashed",
    is_passive: true,
    price: 17400,
    available_trainers: [
      "dbe:king_kai"
    ],
    leveling: {
      cost_per_level: 18400,
      max: 10
    }
  },
  {
    type: "ability",
    id: "ultra_instinct",
    is_passive: false,
    price: 16e4,
    show_hud_icon: true,
    available_trainers: [
      "dbe:whis"
    ],
    aura_properties: {
      ki_bar_color: "white"
    },
    leveling: {
      cost_per_level: 25e3,
      max: 2,
      modifier_multiplier: 1.05
    },
    modifiers: {
      constitution: 1,
      dexterity: 1.2,
      ki_consume: 1,
      size: 1,
      spirit: 1.2,
      strength: 1
    },
    requirements: {
      not_skills: ["hakai"],
      skills: ["divine_ki"]
    }
  }
];
export {
  skills_data
};
