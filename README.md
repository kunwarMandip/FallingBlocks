# FallingBlocks


# Current Working on:
    # Set number of enemy to spawn
    # Set Enemy Type To Spawn
    # Keep Count

    //Lets call this a controller type stuff -> Control how many enemies to spawn. Difference in

    #Lets think about how I can do this
    #I can add a variable in spawnRateController. so, if the amount of enemySpawned >=


# ENTITY class has useless variable


# No difficulty Settings created yet
# Game needs to be move to the next wave
# No way to control Difficulty: EnemySpawnRate, EnemySpeed, EnemyPositionAccuracy
# Only one class for Enemy is Defined #Normal
# Only one Movement and Attack Behaviour for Enemy is defined


# CODE IS SHITTY UNREADABLE. NEEDS TO BE REFACTORED


# Lets make game reset first upon entity touching enemies
# Make enemy increase Score. Make hud Increase Score


# Enemies Controller
# Updates, Spawns and deletes draw
# To spawn, I need to create EnemyDto, EnemyFactory and returns EnemyType


# For reset:
# Reset to the last wave
# I could make a "Game level" class
# and then a wave level class
# so when I want to reset the game, I just make a new instance of the wave level class 
# For game Stats, I can make a temp one for each wave and when the player passes the wave, I just add them 


