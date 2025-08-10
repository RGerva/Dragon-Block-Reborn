const races_data = [
  {
    id: "human",
    regen_rate: 1,
    scale: 1,
    attributes: {
      constitution: 2,
      dexterity: 1,
      spirit: 1,
      strength: 1
    },
    transformations: [
      {
        id: "buffed",
        is_muscular: true,
        modifiers: {
          constitution: 1,
          dexterity: 1.3,
          ki_consume: 1,
          size: 1.05,
          spirit: 1.3,
          strength: 1.3
        },
        aura_properties: {
          color: {
            red: 111,
            green: 212,
            blue: 250
          }
        },
        requirements: {
          z_level: 5
        }
      },
      {
        id: "full_released",
        modifiers: {
          constitution: 1,
          dexterity: 1.8,
          ki_consume: 2,
          size: 1.1,
          spirit: 1.8,
          strength: 1.8
        },
        aura_properties: {
          color: {
            red: 111,
            green: 212,
            blue: 250
          }
        },
        requirements: {
          z_level: 15
        }
      },
      {
        id: "god",
        modifiers: {
          constitution: 1,
          dexterity: 2.6,
          ki_consume: 2,
          size: 1,
          spirit: 2.6,
          strength: 2.6
        },
        aura_properties: {
          type: "divine",
          sound_index: 1,
          color: {
            red: 250,
            green: 130,
            blue: 0
          }
        },
        requirements: {
          skills: ["divine_ki"],
          z_level: 28
        }
      }
    ]
  },
  {
    id: "saiyan",
    regen_rate: 1,
    scale: 1,
    active_customizations: {
      gender: true,
      hair: {
        color_variant_count: 5,
        variant_count: 5
      },
      skin: {
        variant_count: 6
      }
    },
    attributes: {
      constitution: 15,
      dexterity: 10,
      spirit: 7,
      strength: 18
    },
    transformations: [
      {
        id: "oozaru",
        is_armor_visible: false,
        modifiers: {
          constitution: 1,
          dexterity: 1.3,
          ki_consume: 0,
          size: 2,
          spirit: 1.3,
          strength: 1.3
        },
        aura_properties: {
          color: {
            red: 111,
            green: 212,
            blue: 250
          }
        },
        requirements: {
          tail_required: true,
          time_of_day: "night"
        },
        tags: [
          "oozaru"
        ]
      },
      {
        id: "ssj",
        modifiers: {
          constitution: 1,
          dexterity: 1.8,
          ki_consume: 1,
          size: 1,
          spirit: 1.8,
          strength: 1.8
        },
        aura_properties: {
          ki_bar_color: "yellow",
          overridable_by_legendary: true,
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 14
        }
      },
      {
        id: "assj",
        is_muscular: true,
        modifiers: {
          constitution: 1,
          dexterity: 2.2,
          ki_consume: 3,
          size: 1.1,
          spirit: 2.2,
          strength: 2.2
        },
        aura_properties: {
          ki_bar_color: "yellow",
          overridable_by_legendary: true,
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 20
        }
      },
      {
        id: "ssj2",
        modifiers: {
          constitution: 1,
          dexterity: 2.7,
          ki_consume: 2,
          size: 1,
          spirit: 2.7,
          strength: 2.7
        },
        aura_properties: {
          ki_bar_color: "yellow",
          overridable_by_legendary: true,
          sparks: true,
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 25
        }
      },
      {
        id: "ssj3",
        modifiers: {
          constitution: 1,
          dexterity: 3,
          ki_consume: 5,
          size: 1.1,
          spirit: 3,
          strength: 3
        },
        aura_properties: {
          ki_bar_color: "yellow",
          overridable_by_legendary: true,
          sparks: true,
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 30
        }
      },
      {
        id: "ultimate_form",
        modifiers: {
          constitution: 1,
          dexterity: 3.1,
          ki_consume: 0,
          size: 1,
          spirit: 3.1,
          strength: 3.1
        },
        aura_properties: {
          sparks: true,
          color: {
            red: 255,
            green: 255,
            blue: 255
          }
        },
        requirements: {
          skills: ["potential_unleashed"]
        }
      },
      {
        id: "golden_oozaru",
        is_armor_visible: false,
        modifiers: {
          constitution: 1,
          dexterity: 2.1,
          ki_consume: 0,
          size: 2,
          spirit: 2.1,
          strength: 2.1
        },
        aura_properties: {
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          tail_required: true,
          time_of_day: "night",
          z_level: 33
        },
        tags: [
          "oozaru"
        ]
      },
      {
        id: "ssj4",
        modifiers: {
          constitution: 1,
          dexterity: 3.2,
          ki_consume: 3,
          size: 1.1,
          spirit: 3.2,
          strength: 3.2
        },
        aura_properties: {
          ki_bar_color: "yellow",
          sparks: true,
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          tail_required: true,
          z_level: 38
        }
      },
      {
        id: "ssjg",
        has_slim_body: true,
        modifiers: {
          constitution: 1,
          dexterity: 3.4,
          ki_consume: 2,
          size: 1,
          spirit: 3.4,
          strength: 3.4
        },
        aura_properties: {
          type: "divine",
          sound_index: 1,
          color: {
            red: 250,
            green: 130,
            blue: 0
          }
        },
        requirements: {
          skills: ["divine_ki"],
          z_level: 42
        }
      },
      {
        id: "ssjb",
        modifiers: {
          constitution: 1,
          dexterity: 3.6,
          ki_consume: 4,
          size: 1,
          spirit: 3.6,
          strength: 3.6
        },
        aura_properties: {
          sound_index: 1,
          color: {
            red: 0,
            green: 132,
            blue: 250
          }
        },
        requirements: {
          alignment: ["neutral", "good"],
          skills: ["divine_ki"],
          z_level: 48
        }
      },
      {
        id: "ssjr",
        modifiers: {
          constitution: 1,
          dexterity: 3.6,
          ki_consume: 4,
          size: 1,
          spirit: 3.6,
          strength: 3.6
        },
        aura_properties: {
          sound_index: 1,
          color: {
            red: 245,
            green: 0,
            blue: 170
          }
        },
        requirements: {
          alignment: "evil",
          skills: ["divine_ki"],
          z_level: 48
        }
      },
      {
        id: "ssjbe",
        modifiers: {
          constitution: 1,
          dexterity: 3.8,
          ki_consume: 5,
          size: 1,
          spirit: 3.8,
          strength: 3.8
        },
        aura_properties: {
          sound_index: 1,
          color: {
            red: 0,
            green: 132,
            blue: 250
          }
        },
        requirements: {
          alignment: ["neutral", "good"],
          skills: ["divine_ki"],
          z_level: 52
        }
      },
      {
        id: "ssjre",
        modifiers: {
          constitution: 1,
          dexterity: 3.8,
          ki_consume: 5,
          size: 1,
          spirit: 3.8,
          strength: 3.8
        },
        aura_properties: {
          sound_index: 1,
          color: {
            red: 245,
            green: 0,
            blue: 170
          }
        },
        requirements: {
          alignment: "evil",
          skills: ["divine_ki"],
          z_level: 52
        }
      },
      {
        id: "beast",
        modifiers: {
          constitution: 1,
          dexterity: 4,
          ki_consume: 5,
          size: 1,
          spirit: 4,
          strength: 4
        },
        aura_properties: {
          sparks: true,
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          skills: [
            {
              potential_unleashed: {
                min: 10
              }
            }
          ]
        }
      },
      {
        id: "ultra_ego",
        modifiers: {
          constitution: 1,
          dexterity: 3,
          ki_consume: 5,
          size: 1,
          spirit: 4.5,
          strength: 4.5
        },
        aura_properties: {
          sparks: true,
          color: {
            red: 250,
            green: 25,
            blue: 250
          }
        },
        requirements: {
          skills: ["hakai"]
        }
      }
    ]
  },
  {
    id: "namekian",
    regen_rate: 1.6,
    scale: 1.05,
    active_customizations: {
      skin: {
        variant_count: 4
      }
    },
    attributes: {
      constitution: 15,
      dexterity: 9,
      spirit: 16,
      strength: 10
    },
    transformations: [
      {
        id: "full_released",
        modifiers: {
          constitution: 1,
          dexterity: 1.8,
          ki_consume: 2,
          size: 1.1,
          spirit: 1.8,
          strength: 1.8
        },
        aura_properties: {
          color: {
            red: 111,
            green: 212,
            blue: 250
          }
        },
        requirements: {
          z_level: 13
        }
      },
      {
        id: "potential_unleashed",
        modifiers: {
          constitution: 1,
          dexterity: 2.75,
          ki_consume: 2,
          size: 1,
          spirit: 2.75,
          strength: 2.75
        },
        aura_properties: {
          color: {
            red: 250,
            green: 130,
            blue: 0
          }
        },
        requirements: {
          skills: ["potential_unleashed"],
          z_level: 20
        }
      },
      {
        id: "orange_form",
        show_hud_icon: true,
        modifiers: {
          constitution: 1,
          dexterity: 3.7,
          ki_consume: 5,
          size: 1.2,
          spirit: 3.7,
          strength: 3.7
        },
        aura_properties: {
          ki_bar_color: "yellow",
          sound_index: 1,
          color: {
            red: 250,
            green: 130,
            blue: 0
          }
        },
        requirements: {
          skills: ["potential_unleashed"],
          z_level: 50
        }
      }
    ]
  },
  {
    id: "frost_demon",
    regen_rate: 1.2,
    scale: 0.95,
    active_customizations: {
      skin: {
        variant_count: 4
      }
    },
    attributes: {
      constitution: 20,
      dexterity: 8,
      spirit: 7,
      strength: 15
    },
    transformations: [
      {
        id: "second_form",
        modifiers: {
          constitution: 1,
          dexterity: 1.2,
          ki_consume: 1,
          size: 1.1,
          spirit: 1.2,
          strength: 1.2
        },
        aura_properties: {
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          z_level: 5
        }
      },
      {
        id: "third_form",
        is_muscular: true,
        modifiers: {
          constitution: 1,
          dexterity: 1.5,
          ki_consume: 2,
          size: 1.2,
          spirit: 1.5,
          strength: 1.5
        },
        aura_properties: {
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          z_level: 10
        }
      },
      {
        id: "fourth_form",
        modifiers: {
          constitution: 1,
          dexterity: 1.8,
          ki_consume: 1,
          size: 1,
          spirit: 1.8,
          strength: 1.8
        },
        aura_properties: {
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          z_level: 14
        }
      },
      {
        id: "full_power",
        is_muscular: true,
        modifiers: {
          constitution: 1,
          dexterity: 2.2,
          ki_consume: 2,
          size: 1.15,
          spirit: 2.2,
          strength: 2.2
        },
        aura_properties: {
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          z_level: 20
        }
      },
      {
        id: "golden_form",
        modifiers: {
          constitution: 1,
          dexterity: 3.6,
          ki_consume: 3,
          size: 1,
          spirit: 3.6,
          strength: 3.6
        },
        aura_properties: {
          ki_bar_color: "yellow",
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 45
        }
      },
      {
        id: "black_form",
        modifiers: {
          constitution: 1,
          dexterity: 4,
          ki_consume: 4,
          size: 1,
          spirit: 4,
          strength: 4
        },
        aura_properties: {
          color: {
            red: 187,
            green: 41,
            blue: 255
          }
        },
        requirements: {
          z_level: 60
        }
      }
    ]
  },
  {
    id: "majin",
    regen_rate: 2,
    scale: 0.95,
    active_customizations: {
      gender: true,
      skin: {
        variant_count: 3
      }
    },
    attributes: {
      constitution: 13,
      dexterity: 10,
      spirit: 12,
      strength: 15
    },
    transformations: [
      {
        id: "pure_majin",
        modifiers: {
          constitution: 1,
          dexterity: 2.7,
          ki_consume: 2,
          size: 1,
          spirit: 2.7,
          strength: 2.7
        },
        aura_properties: {
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          z_level: 20
        }
      },
      {
        id: "super_majin",
        modifiers: {
          constitution: 1,
          dexterity: 3,
          ki_consume: 4,
          size: 1.1,
          spirit: 3,
          strength: 3
        },
        aura_properties: {
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          z_level: 28
        }
      },
      {
        id: "ultra_majin",
        modifiers: {
          constitution: 1,
          dexterity: 3.2,
          ki_consume: 0,
          size: 1,
          spirit: 3.2,
          strength: 3.2
        },
        aura_properties: {
          color: {
            red: 255,
            green: 28,
            blue: 247
          }
        },
        requirements: {
          z_level: 40
        }
      }
    ]
  },
  {
    id: "bio_android",
    regen_rate: 1.8,
    scale: 1.05,
    active_customizations: {
      skin: {
        variant_count: 6
      }
    },
    attributes: {
      constitution: 12,
      dexterity: 12,
      spirit: 13,
      strength: 13
    },
    transformations: [
      {
        id: "semi_perfect",
        modifiers: {
          constitution: 1,
          dexterity: 1.4,
          ki_consume: 1,
          size: 1.2,
          spirit: 1.4,
          strength: 1.4
        },
        aura_properties: {
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 7
        }
      },
      {
        id: "perfect",
        modifiers: {
          constitution: 1,
          dexterity: 1.8,
          ki_consume: 1,
          size: 1.1,
          spirit: 1.8,
          strength: 1.8
        },
        aura_properties: {
          ki_bar_color: "yellow",
          sparks: true,
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 14
        }
      },
      {
        id: "full_power",
        is_muscular: true,
        modifiers: {
          constitution: 1,
          dexterity: 2.2,
          ki_consume: 2,
          size: 1.1,
          spirit: 2.2,
          strength: 2.2
        },
        aura_properties: {
          ki_bar_color: "yellow",
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 20
        }
      },
      {
        id: "super_perfect",
        modifiers: {
          constitution: 1,
          dexterity: 2.7,
          ki_consume: 1,
          size: 1.1,
          spirit: 2.7,
          strength: 2.7
        },
        aura_properties: {
          ki_bar_color: "yellow",
          sparks: true,
          color: {
            red: 247,
            green: 226,
            blue: 72
          }
        },
        requirements: {
          z_level: 24
        }
      }
    ]
  }
];
export {
  races_data
};
