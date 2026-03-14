package com.diguage.algo.leetcode;

public class _0558_LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-03-14 21:48:07
   */
  public Node intersect(Node quadTree1, Node quadTree2) {
    if (quadTree1.isLeaf) {
      if (quadTree1.val) {
        return new Node(true, true);
      } else {
        return new Node(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft,
          quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
      }
    }
    if (quadTree2.isLeaf) {
      // 妙啊！减少了重复代码！
      return intersect(quadTree2, quadTree1);
    }
    Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
    Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
    Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
    Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
    if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
      && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
      return new Node(true, true);
    }
    return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
  }
  // end::answer[]

  public static class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
      val = _val;
      isLeaf = _isLeaf;
      topLeft = _topLeft;
      topRight = _topRight;
      bottomLeft = _bottomLeft;
      bottomRight = _bottomRight;
    }
  }
}
