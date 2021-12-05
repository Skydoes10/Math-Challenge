package model;

import java.io.Serializable;
import java.util.List;

public class Player implements Comparable<Player>, Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int score;
	private int position;
	private Player parent;
	private Player left;
	private Player right;
	
	public Player(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Player player) {
		int compare = name.compareTo(player.name);
		if (compare == 0) {
			if (score < player.score) {
				return -1;
			}else if (score > player.score) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return compare;
		}
	}
	
	public void add(Player player) {
		if (compareTo(player) > 0) {
			if (left == null) {
				left = player;
				player.parent = this;
				
			}else {
				left.add(player);
			}
		}else if (compareTo(player)< 0) {
			if (right == null) {
				right = player;
				player.parent = this;
			}else {
				right.add(player);
			}
		}
	}
	
	public void remove(Player player) {
		if (player == this) {
			remove();
		}else if (compareTo(player) > 0) {
			right.remove(player);
		}else {
			left.remove(player);
		}
	}
	
	private void remove() {
		Player successor = getSuccesor();
		if (successor.parent != null) {
			if (successor.parent.left == successor) {
				successor.parent.left = null;
			}
			else {
				successor.parent.right = null;
			}
		}
		
		successor.parent = parent;
		successor.left = left;
		successor.right = right;
		
		if(parent != null) {
			if (parent.left == this) {
				parent.left = successor;
			}
			else {
				parent.right = successor;
			}
		}
	}
	
	public Player search(Player player) {
		int search = compareTo(player);
		if ( search == 0) {
			return this;
		}else if (search > 0) {
			return left.search(player);
		}else {
			return right.search(player);
		}
	}
	
	public List<Player> listPlayers(List<Player> players){
		if (left == null && right == null) {
			players.add(this);
			return players;
		}else {
			if (right != null ) {
				players = right.listPlayers(players);
			}
			
			players.add(this);
			
			if (left != null) {
				players = left.listPlayers(players);
			}
			return players;
		}
	}
	
	private Player getSuccesor() {
		if (left == null) {
			return right;
		}else {
			return left.getDirectSuccessor();
		}
	}
	
	private Player getDirectSuccessor() {
		if (right == null) {
			return this;
		}else {
			return right.getDirectSuccessor();
		}
	}
	
	public void plusScore() {
		setScore(score + 10);
	}
	
	public void subtractScore() {
		setScore(score - 10);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Player getLeft() {
		return left;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	public Player getRight() {
		return right;
	}

	public void setRight(Player right) {
		this.right = right;
	}
	
}
