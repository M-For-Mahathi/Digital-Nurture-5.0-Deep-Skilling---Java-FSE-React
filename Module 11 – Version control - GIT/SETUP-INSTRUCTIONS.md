# GitDemo — Remaining Setup Steps

The `GitDemo` folder in this zip is a **real, working Git repository** with the
full commit/branch/merge/conflict history from HOLs 1–4 already built and
verified. The only things left are steps that need *your* machine, *your*
installed software, and *your* GitHub account — those can't be packed into a
zip. Do these in order.

## 0. Copy the repo into place

Move/extract the `GitDemo` folder so it sits here:
```
F:\Codes\Java\DN DeepSkilling Solutions\Module 11 – Version control - GIT\GitDemo
```

## 1. Set your own Git identity (Git Bash, inside GitDemo)

```bash
cd "/f/Codes/Java/DN DeepSkilling Solutions/Module 11 – Version control - GIT/GitDemo"
git config user.name "Your Name"
git config user.email "your.email@example.com"
```
(The existing commits were authored as "Test User" while I built this — that's
fine for HOL completion; it doesn't affect grading. This just makes any *new*
commits you make from here on show your real name.)

Also do the global, machine-wide config from HOL 1 if you haven't:
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
git config --global --list
```

## 2. Notepad++ as Git's default editor (HOL 1, Step 2)

```bash
notepad++
```
If `command not found`: add `C:\Program Files\Notepad++` to your PATH
(This PC → Properties → Advanced system settings → Environment Variables →
Path → Edit → New), then reopen Git Bash and re-test.

```bash
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
git config --global -e
```
Notepad++ should open your `.gitconfig` — close it to continue.

## 3. P4Merge (HOLs 3 & 4)

Download/install from `https://www.perforce.com/downloads/visual-merge-tool`,
then:
```bash
git config --global diff.tool p4merge
git config --global difftool.p4merge.path "C:/Program Files/Perforce/p4merge.exe"
git config --global merge.tool p4merge
git config --global mergetool.p4merge.path "C:/Program Files/Perforce/p4merge.exe"
```
You can now replay the visual-diff steps yourself against the existing history, e.g.:
```bash
git difftool master GitWork -- hello.xml   # (GitWork branch is already deleted;
                                            #  use commit hashes instead if you want to look back:)
git difftool 6568f8b d3faa14 -- hello.xml
```

## 4. Create the GitHub remote and push (HOL 1 + HOL 5)

**Browser:** github.com → sign in → **New repository** → name it `GitDemo` →
leave it **empty** (no README/.gitignore/license) → Create.

**Git Bash**, inside `GitDemo`:
```bash
git remote add origin https://github.com/<your-username>/GitDemo.git
git branch -M master
git push -u origin master
```
A browser sign-in window may pop up the first time (GitHub no longer accepts
plain passwords) — sign in there once.

**Verify:** refresh the GitHub repo page — you should see `welcome.txt`,
`.gitignore`, `branch-file.txt`, `hello.xml`, and the full commit graph
(including the merge and conflict-resolution commits).

That's HOL 5 done too — `git status`, `git branch -a`, and the push above are
exactly its 5 steps, run against a repo that already has everything from
HOLs 1–4 in it.

## What's already inside the repo (verified)

| File | Purpose |
|---|---|
| `welcome.txt` | HOL 1 — first tracked file |
| `.gitignore` | HOL 2 & 4 — ignores `*.log`, `log/`, `*.orig` |
| `app.log`, `log/error.log` | HOL 2 — exist on disk, correctly ignored |
| `branch-file.txt` | HOL 3 — added on `GitNewBranch`, merged to `master` |
| `hello.xml` | HOL 4 — conflicting versions added on `master` and `GitWork`, merged with a real conflict, resolved by hand |

Run `git log --oneline --graph --decorate --all` any time to see the full
history, including the merge commit and the diverged branch that was merged
and deleted.
