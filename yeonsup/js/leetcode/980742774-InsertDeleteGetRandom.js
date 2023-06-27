class RandomizedSet {
  constructor() {
      this.map = new Map();
      this.list = [];
  }
  /** 
  * @param {number} val
  * @return {boolean}
  */
  insert = function(val) {
      if(this.map.has(val)) return false;
      this.map.set(val, this.list.length);
      this.list.push(val);
      return true;
  };

  /**
  * @param {number} val
  * @return {boolean}
  */
  remove = function(val) {
      if(!this.map.has(val)) return false;
      const idx = this.map.get(val);
      this._swap(idx, this.list.length - 1);
      this.list.pop();
      this.map.set(this.list[idx], idx);
      this.map.delete(val);
      return true;
  };

  /**
  * @return {number}
  */
  getRandom() {
      return this.list[Math.floor(Math.random() * (this.list.length - 0))];
  };

  _swap(a, b) {
      const temp = this.list[a];
      this.list[a] = this.list[b];
      this.list[b] = temp;
  };

  /** 
  * Your RandomizedSet object will be instantiated and called as such:
  * var obj = new RandomizedSet()
  * var param_1 = obj.insert(val)
  * var param_2 = obj.remove(val)
  * var param_3 = obj.getRandom()
  */
}