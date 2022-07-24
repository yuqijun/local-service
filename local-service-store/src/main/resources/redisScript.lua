"redis.call('GET',KEY[1])<KEY[2] then return  nil
else local number = redis.call('GET',KEY[1]); local update =number - KEY[2] redis.call('SET',update); return 1";